/*
    CoMaSw - Contract Management Software is a software developed for 
    the final academic project of the Universidade da Coruña (UDC).

    Copyright (C) 2022  Catarina García Cal (catarina.garcia.cal@udc.es)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
 any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/

package com.comasw.viewController.catalog.type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.omnifaces.util.Ajax;
import org.primefaces.PrimeFaces;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;

import com.comasw.model.tables.pojos.CtPromotionType;
import com.comasw.model.tables.pojos.VwUsers;
import com.comasw.ejb.catalog.type.PromotionTypeEJBLocal;
import com.comasw.generalClass.BasicHistoricType;
import com.comasw.interfaces.IEditableHistoricTable;
import com.comasw.utilities.Formatter;
import com.comasw.utilities.Utilities;

@Named
@ViewScoped
public class PromotionTypeController extends BasicHistoricType<CtPromotionType>
		implements Serializable, IEditableHistoricTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6789853537280113269L;

	Logger logger = (Logger) LogManager.getLogger(PromotionTypeController.class);

	private static final Integer ENTITY_TYPE_ID = Integer.valueOf(dbDefinitions.getString("ENTITY_TYPE_ID_PROM"));

	@Inject
	private ExternalContext externalContext;
	@Inject
	private FacesContext facesContext;

	@EJB
	private PromotionTypeEJBLocal promotionTypeEJB;

	// -------------------
	// METHODS
	// -------------------

	/**
	 * 
	 */
	public PromotionTypeController() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {

		if (this.getNewData() == null) {
			this.setNewData(new CtPromotionType());
		}

		if (this.getSearchDate() == null) {
			this.setSearchDate(LocalDate.now().atStartOfDay());
		}

		if (this.getDataList() == null) {
			this.setDataList(new ArrayList<CtPromotionType>());
		}

		if (this.getFilteredDataList() == null) {
			this.setFilteredDataList(new ArrayList<CtPromotionType>());
		}

		if (this.getSelectedDataList() == null) {
			this.setSelectedDataList(new ArrayList<CtPromotionType>());
		}

		if (this.getFilteredDataList() == null) {
			this.setFilteredDataList(new ArrayList<CtPromotionType>());
		}

		if (this.getSelectedData() == null) {
			this.setSelectedData(new CtPromotionType());
		}

		if (this.getHistoricDataList() == null) {
			this.setHistoricDataList(new ArrayList<CtPromotionType>());
		}

		if (this.getSelectedHistoricData() == null) {
			this.setSelectedHistoricData(new CtPromotionType());
		}

		if (this.getFilteredHistoricDataList() == null) {
			this.setFilteredHistoricDataList(new ArrayList<CtPromotionType>());
		}

		if (this.getBackupHistoricDataList() == null) {
			this.setBackupHistoricDataList(new ArrayList<CtPromotionType>());
		}

		if (this.getLoggedUser() == null) {
			this.setLoggedUser((VwUsers) externalContext.getSessionMap().get("applicationUser"));
		}

	}

	@Override
	public void loadDataList() {
		String message = "LOAD DATA";
		String messageDetail = "";
		if (this.isHistoricSearchDataCriteria()) {
			this.setDataList(promotionTypeEJB.findAllData());
			if (this.getDataList().isEmpty()) {
				logger.info("No data to show");

			} else {
				logger.info("Load data sucessful");
			}
		} else {
			if (this.getSearchDate() == null) {
				messageDetail = "The date value to search is null. Please fill the search date field";
				logger.error(message + " - " + messageDetail);
				FacesContext.getCurrentInstance().validationFailed();
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, message, messageDetail));
			} else {
				this.setDataList(promotionTypeEJB.findDataBySearchDate(searchDate));
				if (this.getDataList().isEmpty()) {
					logger.info("No data to show");

				} else {
					logger.info("Load data sucessful");
				}
			}
		}
	}

	@Override
	public void loadHistoricalDataList() {
		Integer promotionTypeId;
		if (this.getSelectedData() == null) {
			logger.error("The promotion type select is null");
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, "LOAD HISTORIC DATA",
					"The promotion type select is null");
		} else {
			promotionTypeId = this.getSelectedData().getPromotionTypeId();
			this.setHistoricDataList(promotionTypeEJB.findDataByPromotionTypeId(promotionTypeId));
			if (this.getHistoricDataList().isEmpty()) {
				logger.info("No historical data data to show for promotion_type_id " + promotionTypeId);

			} else {
				logger.info("Load historical data sucessful for promotion_type_id " + promotionTypeId);
				System.out.println("datalist: " + historicDataList.toString());
			}

		}
	}

	@Override
	public void pushSearchButton() {
		String message = "SEARCH DATA";
		String messageDetail = "";

		this.loadDataList();
		if (this.getDataList().isEmpty()) {
			messageDetail = "No data to show for the specific search criteria";
			logger.info(message + " - " + messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);

		} else {
			this.resetFilterDataTable();
			this.changeSearchDataTableTitle();

			PrimeFaces.current().executeScript("PF('searchListWidget').show();");
		}

	}

	@Override
	public void pushShowDetailRowButton() {
		String message = "SHOWN HISTORIC DATA";
		String messageDetail = "";

		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(DATA_TABLE_ID);

		// Gets the selected data
		this.setSelectedData((CtPromotionType) dataTable.getRowData());

		if (this.getSelectedData() == null || this.getSelectedData().getPromotionTypeId() == null
				|| this.getSelectedData().getPromotionTypeId() == 0) {
			messageDetail = "The promotion type is null";
			logger.error(message + " - " + messageDetail);
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);

		} else {
			this.setShowSelectedData(true);
			this.getSelectedDataList().clear();
			this.getSelectedDataList().add(this.getSelectedData());
			this.refreshHistoricDataTable();

			messageDetail = "Shown data for promotion: ";
			logger.info(message + " - " + messageDetail + this.getSelectedData().toString());
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
					messageDetail + this.getSelectedData().getCode());

			PrimeFaces.current().executeScript("PF('searchListWidget').hide();");
			PrimeFaces.current().executeScript("PF('multipleAccordionPanelWidget').selectAll();");

		}

	}

	@Override
	public void onRowInit(RowEditEvent<?> event) {
		CtPromotionType dataObject;
		String message, message_detail;

		message = "EDIT ROW";

		// Gets the object to modify
		dataObject = (CtPromotionType) event.getObject();

		// If we are editing a row, we must disabled all the other buttons
		this.setEditingMode(true);

		try {
			// The user was pushed the edit button
			message_detail = "Editing promotion type: " + dataObject.toString();
			logger.info(message_detail);

			// Store backup from the current data of the table
			Utilities.copyGenericList(this.historicDataList, this.backupHistoricDataList);
			// Sets the modified fields to the new values
			dataObject.setModifDate(LocalDateTime.now());
			dataObject.setModifUser(loggedUser.getUserCode());
			// Show an informative message
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, message_detail);

		} catch (EJBException e) {
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwParseException")) {
				message_detail = "PARSE ERROR - " + ne.getMessage();
				logger.fatal(message_detail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, message_detail);

			} else {
				message_detail = "ERROR - " + ne.getMessage();
				logger.fatal(message_detail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, message_detail);
			}

		} catch (Exception e) {
			message_detail = "ERROR - " + e.getCause().toString();
			logger.fatal(message_detail);
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, message_detail);
		}

	}

	@Override
	public void onRowEdit(RowEditEvent<?> event) throws ValidatorException {
		CtPromotionType dataObject;
		String message, messageDetail;
		boolean validation = false;
		CtPromotionType originalDataObject;
		CtPromotionType otherRecordDataObject;

		message = "SAVE EDIT ROW";

		// Retrieved the data that was modified
		dataObject = (CtPromotionType) event.getObject();

		// NOTE: the table contains the modified data for both the directly modified
		// record data
		// and the endDate and startDate for the previous and subsequent records
		// respectively (if applicable)
		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
				.findComponent(HISTORIC_DATA_TABLE_ID);

		int pos = dataTable.getRowIndex();
		int lastRow = dataTable.getRowCount() - 1;

		// Validates the data
		validation = objectValidation(dataObject);

		try {
			if (validation) {
				// Check if the dates are changed
				originalDataObject = this.backupHistoricDataList.get(pos);
				if (lastRow != 0) {
					// There are more than one row, so if some date is changed, the previous or
					// subsequent data row could be also modified

					if (!originalDataObject.getStartDate().isEqual(dataObject.getStartDate())
							|| !originalDataObject.getEndDate().isEqual(dataObject.getEndDate())) {

						if (!originalDataObject.getStartDate().isEqual(dataObject.getStartDate())) {
							if (pos != 0) {
								// Change it's start date and it's not the first record ==> the previous end
								// date record could be also changed

								// Retrieve the original previous record
								otherRecordDataObject = this.backupHistoricDataList.get(pos - 1);
								if (!otherRecordDataObject.getEndDate()
										.isEqual(dataObject.getStartDate().minusDays(1))) {
									// The original previous record and the current new (modified) record are not
									// consecutives ==> modify the previous record
									dataTable.setRowIndex(pos - 1);
									otherRecordDataObject = (CtPromotionType) dataTable.getRowData();
									dataTable.setRowIndex(pos);

									promotionTypeEJB.updateHistoricDataRecord(otherRecordDataObject);
									// deletes the original data for this record
									otherRecordDataObject = this.backupHistoricDataList.get(pos - 1);
									promotionTypeEJB.deleteData(otherRecordDataObject);

								}

							}
						}
						if (!originalDataObject.getEndDate().isEqual(dataObject.getEndDate())) {
							if (pos != lastRow) {
								// Change it's start date and it's not the last record ==> the subsequent end
								// date record could be also changed

								// Retrieve the original subsequent record
								otherRecordDataObject = this.backupHistoricDataList.get(pos + 1);
								if (!dataObject.getEndDate()
										.isEqual(otherRecordDataObject.getStartDate().minusDays(1))) {
									// The current new (modified) record and the original subsequent record are not
									// consecutives ==> modify the subsequent record
									dataTable.setRowIndex(pos + 1);
									otherRecordDataObject = (CtPromotionType) dataTable.getRowData();
									dataTable.setRowIndex(pos);
									promotionTypeEJB.updateHistoricDataRecord(otherRecordDataObject);
									// deletes the original data for this record
									otherRecordDataObject = this.backupHistoricDataList.get(pos + 1);
									promotionTypeEJB.deleteData(otherRecordDataObject);
								}
							}
						}
					}
				}

				// delete the original data of the record
				promotionTypeEJB.deleteData(originalDataObject);
				// update the current data record
				promotionTypeEJB.updateHistoricDataRecord(dataObject);

				// Check if the status was changed to cancel --> if so, we must update the
				// status of the subsequent rows
				if (this.isToCancel()) {
					int i;
					for (i = pos + 1; i <= lastRow; i++) {
						dataTable.setRowIndex(i);
						dataObject = (CtPromotionType) dataTable.getRowData();
						// promotionTypeEJB.updateHistoricDataRecord(dataObject);
						promotionTypeEJB.updateData(dataObject);
					}

					logger.info("Updated the status to cancel for the subsequent rows");

				}

				// set the row index to the current position
				dataTable.setRowIndex(pos);

				// reload the list
				this.loadHistoricalDataList();

				// Evaluates if the data was by adding or update
				messageDetail = "The changes for promotion" + dataObject.toString() + " has done";
				logger.info(messageDetail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);

				// return the default values of the control variables
				this.setControlVariablesToDefault();

				messageDetail = "Storage the modified data sucessfully";
				logger.info(messageDetail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);
			} else {
				messageDetail = "ERROR - Data values are incorrect";
				logger.info(messageDetail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);
				FacesContext.getCurrentInstance().validationFailed();

			}

		} catch (EJBException e) {
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwParseException")) {
				messageDetail = "PARSE ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				FacesContext.getCurrentInstance().validationFailed();

			} else {
				messageDetail = "ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				FacesContext.getCurrentInstance().validationFailed();
			}

		} catch (Exception e) {
			messageDetail = "ERROR - " + e.getCause().toString();
			logger.fatal(messageDetail);
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			FacesContext.getCurrentInstance().validationFailed();
		}

	}

	@Override
	public void onRowCancel(RowEditEvent<?> event) {
		CtPromotionType dataObject;
		String message, messageDetail;

		message = "CANCEL UPDATE ROW";

		// Retrieved the data that was modified
		dataObject = (CtPromotionType) event.getObject();

		try {
			this.refreshHistoricDataTable();
			messageDetail = "The changes for promotion type " + dataObject.toString() + " was cancelled";
			logger.info(messageDetail);
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);
			// return the default values of the control variables
			this.setControlVariablesToDefault();

		} catch (Exception e) {
			messageDetail = "ERROR - " + e.getCause().toString();
			logger.fatal(messageDetail);
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
		}

	}

	@Override
	public void pushAddNewRowButton() {
		String message, messageDetail;
		DataTable dataTable;
		CtPromotionType currentData = null;

		message = "ADD ROW";

		try {

			// Store the current data
			Utilities.copyGenericList(this.historicDataList, this.backupHistoricDataList);

			// Gets the current data
			dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
					.findComponent(HISTORIC_DATA_TABLE_ID);
			// pos = dataTable.getRowIndex();
			this.setCurrentHistoricRow(dataTable.getRowIndex());
			currentData = (CtPromotionType) dataTable.getRowData();
			this.setSelectedHistoricData((CtPromotionType) Utilities.deepClone(currentData));

			this.setNewData(new CtPromotionType());
			this.getNewData().from(currentData);

			// Sets the fromAddingRow value to true
			this.setFromAddingRow(true);
			this.changeNewDialogHeader();

			PrimeFaces.current().executeScript("PF('createNewDialogWidget').show();");

		} catch (EJBException e) {
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwParseException")) {
				messageDetail = "PARSE ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);

			} else {
				messageDetail = "ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}

		} catch (Exception e) {
			messageDetail = "ERROR - " + e.getCause().toString();
			logger.fatal(messageDetail);
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
		}
	}

	@Override
	public void pushDeleteRowButton() {
		String message, messageDetail;

		DataTable dataTable;
		CtPromotionType currentData;

		message = "DELETE ROW";

		try {
			// Gets the current data
			dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
					.findComponent(HISTORIC_DATA_TABLE_ID);
			// pos = dataTable.getRowIndex();
			this.setCurrentHistoricRow(dataTable.getRowIndex());
			currentData = (CtPromotionType) dataTable.getRowData();
			this.setSelectedHistoricData((CtPromotionType) Utilities.deepClone(currentData));

			this.changeDeleteMessage();

			PrimeFaces.current().executeScript("PF('deleteRowDialogWidget').show();");

		} catch (EJBException e) {
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwParseException")) {
				messageDetail = "PARSE ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);

			} else {
				messageDetail = "ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}

		} catch (Exception e) {
			messageDetail = "ERROR - " + e.getCause().toString();
			logger.fatal(messageDetail);
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
		}

	}

	@Override
	public void pushCreateNewButton() {

		// Set the default dates and input values for the new data
		this.setNewData(new CtPromotionType());
		this.getNewData().setEntityTypeId(ENTITY_TYPE_ID);
		this.getNewData().setStartDate(Formatter.stringToLocalDateTime(Formatter.DEFAULT_START_DATE));
		this.getNewData().setEndDate(Formatter.stringToLocalDateTime(Formatter.DEFAULT_END_DATE));
		this.getNewData().setInputUser(this.loggedUser.getUserCode());
		this.getNewData().setInputDate(LocalDateTime.now());

		// Change the header to the new dialog
		this.changeNewDialogHeader();

		PrimeFaces.current().executeScript("PF('createNewDialogWidget').show();");

	}

	@Override
	public void pushConfirmButtonCreateNewDialog() {
		String message = "INSERT NEW DATA";
		String messageDetail = "";
		boolean error = false;
		Integer row = this.getCurrentHistoricRow();

		try {
			if (this.objectValidation(this.getNewData())) {
				if (this.isFromAddingRow()) {
					// Gets the table
					DataTable dataTable = (DataTable) facesContext.getViewRoot().findComponent(HISTORIC_DATA_TABLE_ID);
					error = splitRecords(dataTable, row, this.getNewData());
				} else {
					// create a new object
					promotionTypeEJB.insertData(this.getNewData());
					CtPromotionType object = promotionTypeEJB
							.findDataBySearchDateAndCode(this.getNewData().getStartDate(), this.getNewData().getCode());

					this.setSelectedData(object);
					this.getSelectedDataList().clear();
					this.getSelectedDataList().add(this.getSelectedData());
					// this.setInjectSelectedData(object);

					messageDetail = "Data saves succesfully";
					logger.info("Create promotion type: " + this.getNewData().toString() + " - " + messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);
				}

			} else {
				error = true;
			}
		} catch (EJBException e) {
			error = true;
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwDataAccessException")) {
				messageDetail = "DATA ACCES ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			} else if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwParseException")) {
				messageDetail = "PARSE ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			} else {
				messageDetail = "ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);
			}

		} catch (Exception e) {
			error = true;
			messageDetail = "ERROR - " + e.getMessage();
			logger.fatal(messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);
		} finally {
			if (error) {
				facesContext.validationFailed();
			} else {

				// this.refreshSelectedDataAttribute();

				if (this.isFromAddingRow()) {
					this.refreshHistoricDataTable();
					// Ajax.update(HISTORIC_DATA_TABLE_ID);
					this.setFromAddingRow(false);

				} else {
					// Ajax.update(DATA_TABLE_ID);
					this.refreshHistoricDataTable();
					this.setShowSelectedData(true);
					PrimeFaces.current().executeScript("PF('multipleAccordionPanelWidget').selectAll();");
					messageDetail = "Shown data for promotion: ";
					logger.info(message + " - " + messageDetail + this.getNewData().toString());
					createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail + this.getNewData().getCode());
				}
				PrimeFaces.current().executeScript("PF('createNewDialogWidget').hide();");

			}
		}

	}

	@Override
	public void pushCancelButtonCreateNewDialog() {
		if (this.isFromAddingRow()) {
			this.refreshHistoricDataTable();
			this.setFromAddingRow(false);
		}
		this.changeNewDialogHeader();
		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
				.findComponent(HISTORIC_DATA_TABLE_ID);
		dataTable.resetRows();

	}

	@Override
	public void pushCleanButtonCreateNewDialog() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pushConfirmButtonDeleteDialog() {
		String message = "DELETE ROW";
		String messageDetail = "";
		int currentPos, lastPos;
		boolean error = false;

		currentPos = -1;
		lastPos = -1;

		try {
			if (this.getSelectedHistoricData() != null) {
				// Gets the data
				DataTable dataTable = (DataTable) facesContext.getViewRoot().findComponent(HISTORIC_DATA_TABLE_ID);
				currentPos = this.getRowHistoricSelected();
				lastPos = dataTable.getRowCount() - 1;

				if ((currentPos != 0) && (currentPos != lastPos)) {
					// middleRow ==> the previous end date and the subsequent start date must be
					// consecutive records ==> modify the previous end date to the subsequent start
					// date minus 1 day

					// Previous row data
					dataTable.setRowIndex(currentPos - 1);
					CtPromotionType previousRecord = (CtPromotionType) dataTable.getRowData();
					CtPromotionType previousRecordOriginalData = (CtPromotionType) Utilities.deepClone(previousRecord);

					// Subsequent row data
					dataTable.setRowIndex(currentPos + 1);
					CtPromotionType subsequentRecord = (CtPromotionType) dataTable.getRowData();

					// Set the endDate of the previows record to the startDate minus one date of the
					// subsequent record
					previousRecord.setEndDate(subsequentRecord.getStartDate().minusDays(1));
					previousRecord.setModifDate(LocalDateTime.now());
					previousRecord.setModifUser(this.getLoggedUser().getUserCode());

					// delete the selected data
					promotionTypeEJB.deleteData(this.getSelectedHistoricData());

					// delete the original previous record (to eliminate overlaps)
					promotionTypeEJB.deleteData(previousRecordOriginalData);

					// Update the previous record with the new endDate
					promotionTypeEJB.updateHistoricDataRecord(previousRecord);

					messageDetail = "Data deletes succesfully";
					logger.info("Delete promotion type: " + this.getSelectedHistoricData().toString() + " - "
							+ messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);

					logger.info("Update the previous record end date sucessfully");
				} else {

					// delete the selected data
					promotionTypeEJB.deleteData(this.getSelectedHistoricData());

					messageDetail = "Data deletes succesfully";
					logger.info("Delete promotion type: " + this.getSelectedHistoricData().toString() + " - "
							+ messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);
				}

			} else {
				error = true;
				messageDetail = "ERROR - Selected data is null";
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			}
		} catch (EJBException e) {
			error = true;
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwDataAccessException")) {
				messageDetail = "DATA ACCES ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			} else if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwParseException")) {
				messageDetail = "PARSE ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			} else {
				messageDetail = "ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);
			}

		} catch (Exception e) {
			error = true;
			messageDetail = "ERROR - " + e.getMessage();
			logger.fatal(messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);
		} finally {
			if (error) {
				facesContext.validationFailed();
			} else {

				if (lastPos == 0) {
					// if it was only one row, reset the selected data
					this.setSelectedData(null);
					this.getSelectedDataList().clear();
					this.getHistoricDataList().clear();
					this.setShowSelectedData(false);	
				} else {
					this.refreshHistoricDataTable();
				}
			}
		}
	}

	@Override
	public void pushCancelButtonDeleteDialog() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetObjectValues() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean objectValidation(Object dataObject) {

		CtPromotionType objectToValidate;
		String message = "DATA VALIDATION";
		String messageDetail = "";

		LocalDateTime minDate = Formatter.stringToLocalDateTime("01/01/1900");
		LocalDateTime maxDate = Formatter.stringToLocalDateTime("31/12/9999");

		boolean validation = true;

		objectToValidate = (CtPromotionType) dataObject;

		if (objectToValidate != null) {

			if (objectToValidate.getCode() != null) {
				objectToValidate.setCode(objectToValidate.getCode().toUpperCase().trim());
			}

			if (objectToValidate.getName() != null) {
				objectToValidate.setName(objectToValidate.getName().toUpperCase().trim());
			}

			if (objectToValidate.getDescription() != null) {
				objectToValidate.setDescription(objectToValidate.getDescription().trim());
			}

			if (objectToValidate.getStartDate() == null) {
				messageDetail = "ERROR - The start date of the promotion type can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else if (objectToValidate.getStartDate().compareTo(minDate) < 0) {
				messageDetail = "ERROR - The start date of the promotion type can not be less than "
						+ Formatter.localDateTimeToString(minDate);
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else if (objectToValidate.getStartDate().compareTo(maxDate) > 0) {
				messageDetail = "ERROR - The start date of the promotion type can not be greater than "
						+ Formatter.localDateTimeToString(maxDate);
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			}

			if (objectToValidate.getEndDate() == null) {
				messageDetail = "ERROR - The end date of the promotion type can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else if (objectToValidate.getEndDate().compareTo(minDate) < 0) {
				messageDetail = "ERROR - The end date of the promotion type can not be less than "
						+ Formatter.localDateTimeToString(minDate);
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else if (objectToValidate.getEndDate().compareTo(maxDate) > 0) {
				messageDetail = "ERROR - The end date of the promotion type can not be greater than "
						+ Formatter.localDateTimeToString(maxDate);
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			}

			if (objectToValidate.getCode() == null || objectToValidate.getCode().length() == 0) {
				messageDetail = "ERROR - The code of the promotion type can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else if (((Integer) objectToValidate.getCode().length())
					.compareTo(BasicHistoricType.CODE_FIELD_LENGTH_MAX) > 0) {
				// length characters exceeds the maximum length
				messageDetail = "Error - The code of the promotion type (" + objectToValidate.getCode().length()
						+ " characters) exceeds the limit of " + BasicHistoricType.CODE_FIELD_LENGTH_MAX.toString()
						+ " characters";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			}
			if (objectToValidate.getName() == null || objectToValidate.getName().length() == 0) {
				messageDetail = "ERROR - The name of the promotion type can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else if (((Integer) objectToValidate.getName().length())
					.compareTo(BasicHistoricType.NAME_FIELD_LENGTH_MAX) > 0) {
				// length characters exceeds the maximum length
				messageDetail = "Error - The name of the promotion type (" + objectToValidate.getName().length()
						+ " characters) exceeds the limit of " + BasicHistoricType.NAME_FIELD_LENGTH_MAX.toString()
						+ " characters";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			}

			if (objectToValidate.getDescription() == null || objectToValidate.getDescription().length() == 0) {
				messageDetail = "ERROR - The description of the promotion type can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else if (((Integer) objectToValidate.getDescription().length())
					.compareTo(BasicHistoricType.DESCRIPTION_FIELD_LENGTH_MAX) > 0) {
				// length characters exceeds the maximum length
				messageDetail = "Error - The description of the promotion type ("
						+ objectToValidate.getDescription().length() + " characters) exceeds the limit of "
						+ BasicHistoricType.DESCRIPTION_FIELD_LENGTH_MAX.toString() + " characters";

				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			}

			if (objectToValidate.getApplicationLevelId() == null) {
				validation = false;
				messageDetail = "ERROR - The application level can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}

			if (objectToValidate.getDiscountTypeId() == null) {
				validation = false;
				messageDetail = "ERROR - The discount type can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}

			if (objectToValidate.getDiscountValue() == null
					|| (objectToValidate.getDiscountValue().compareTo(BigDecimal.valueOf(0)) < 0)) {
				messageDetail = "ERROR - The discount value must be a positive number";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			}

			if (objectToValidate.getStatusId() == null) {
				validation = false;
				messageDetail = "ERROR - The status can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}

			if (validation) {
				// no error --> update panel
				Ajax.update(NEW_PANEL_DATA_ID);
			}

		} else {
			messageDetail = "ERROR - Empty values";
			logger.error(messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			validation = false;
		}
		return validation;
	}

	@Override
	public void retrieveBackupData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInitVariablesToDefault() {

		this.setEditingMode(false);
		this.setSearchDate(LocalDate.now().atStartOfDay());
		this.setFromAddingRow(false);
		this.setToCancel(false);
		this.setPrevStatusId(-1);
		this.setShowSelectedData(false);
		this.setHistoricSearchDataCriteria(false);

	}

	@Override
	public void setControlVariablesToDefault() {
		this.setInitVariablesToDefault();

	}

	@Override
	public void resetFilterDataTable() {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dataTableWidget').clearFilters()");
	}

	@Override
	public void resetFilterHistoricDataTable() {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('historicTableWidget').clearFilters()");

	}

	@Override
	public void refreshDataTable() {
		this.resetFilterDataTable();
		this.loadDataList();
		Ajax.update(DATA_TABLE_ID);
	}

	@Override
	public void refreshHistoricDataTable() {
		if (this.getSelectedData() == null) {
			// recover the selected data from the selected table
			if (this.getSelectedDataList().get(0) != null) {
				this.setSelectedData(this.getSelectedDataList().get(0));
			}
		}
		this.resetFilterHistoricDataTable();
		this.loadHistoricalDataList();
		Ajax.update(HISTORIC_DATA_TABLE_ID);
	}

	@Override
	public void changeStatus(ValueChangeEvent e) {
		// Integer oldStatusId = (Integer) e.getOldValue();
		Integer newStatusId = (Integer) e.getNewValue();
		Integer originalStatusId;

		// Gets the current User
		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
				.findComponent(HISTORIC_DATA_TABLE_ID);
		CtPromotionType data = (CtPromotionType) dataTable.getRowData();

		this.setSelectedHistoricData(data);

		// Gets the row of the current User
		String row = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("currentHistoricalRow");
		this.setCurrentHistoricRow(Integer.parseInt(row));

		// Gets the status Id previous to the edition of the row
		originalStatusId = this.getBackupHistoricDataList().get(this.getCurrentRow()).getStatusId();

		if (STATUS_ID_CANC.equals(originalStatusId)) {
			// The original status was cancel status --> change status is not permitted
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, "STATUS ERROR",
					"The status CANCEL can not be changed");
			data.setStatusId(originalStatusId);
			Ajax.updateColumn(dataTable, dataTable.getRowIndex());
		} else {
			// The original status was not cancel --> could be change
			if (STATUS_ID_CANC.equals(newStatusId)) {
				// New status = cancel
				// Set cancelFlag to true
				this.setToCancel(true);
				// Show confirmation dialog to change to cancel status (if confirm we need to
				// change
				// all subsequent rows to cancel status)
				this.changeStatusMessage();
				// Ajax.update("form:cancelStatusDialog");
				PrimeFaces.current().executeScript("PF('cancelStatusDialogWidget').show();");
			} else {
				// Other status than cancel
				if (this.getPrevStatusId() > -1) {
					// There is a previous change status in the same modification
					if (STATUS_ID_CANC.equals(this.prevStatusId)) {
						// the previous selection into the edition was cancel --> revert changes
						this.revertSubsequentCancelStatus();
					}
				}
			}

			// set the previous status id to the new status Id
			this.setPrevStatusId(newStatusId);
		}
	}

	@Override
	public void pushConfirmButtonChangeStatus() {
		String message = "CHANGE STATUS";
		String messageDetail = "";
		int i, currentPos, lastPos;
		boolean error = false;

		try {
			if (this.getSelectedHistoricData() != null) {

				// Gets the data
				DataTable dataTable = (DataTable) facesContext.getViewRoot().findComponent(HISTORIC_DATA_TABLE_ID);
				currentPos = this.getCurrentHistoricRow();
				lastPos = dataTable.getRowCount() - 1;

				this.setToCancel(true);

				if (currentPos != lastPos) {
					// change status from subsequent rows
					for (i = (currentPos + 1); i <= lastPos; i++) {
						dataTable.setRowIndex(i);
						((CtPromotionType) dataTable.getRowData()).setStatusId(STATUS_ID_CANC);
						Ajax.updateRow(dataTable, i);

					}

					dataTable.setRowIndex(currentPos);

					messageDetail = "Subsequent status change succesfully";
					logger.info("Change status promotion type: " + this.getSelectedHistoricData().toString() + " - "
							+ messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);
				}

			} else {
				error = true;
				messageDetail = "ERROR - Selected data is null";
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			}
		} catch (EJBException e) {
			error = true;
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwDataAccessException")) {
				messageDetail = "DATA ACCES ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			} else if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwParseException")) {
				messageDetail = "PARSE ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			} else {
				messageDetail = "ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);
			}

		} catch (Exception e) {
			error = true;
			messageDetail = "ERROR - " + e.getMessage();
			logger.fatal(messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);
		} finally {
			if (error) {
				facesContext.validationFailed();
			}
		}

	}

	@Override
	public void revertSubsequentCancelStatus() {
		DataTable dataTable;
		int currentPos, lastPos;
		CtPromotionType currentObject;

		dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(HISTORIC_DATA_TABLE_ID);
		lastPos = dataTable.getRowCount() - 1;
		currentPos = this.getCurrentHistoricRow();

		if (this.isToCancel()) {

			// System.out.println("actualStatusId: " + currentUser.getStatusId());
			if (this.isFromAddingRow()) {
				// The old value was equal to the previous row
				currentObject = (CtPromotionType) dataTable.getRowData();
				currentObject
						.setStatusId(((CtPromotionType) this.backupHistoricDataList.get(currentPos - 1)).getStatusId());
				Ajax.updateRow(dataTable, currentPos);
			}

			for (int i = currentPos + 1; i <= lastPos; i++) {
				dataTable.setRowIndex(i);

				currentObject = (CtPromotionType) dataTable.getRowData();
				if (!STATUS_ID_CANC.equals(currentObject.getStatusId())) {
					// the status of the row is not cancel ==> updates the status
					// and the modif values

					currentObject.setStatusId(((CtPromotionType) this.backupHistoricDataList.get(i)).getStatusId());
					currentObject.setInputDate(LocalDateTime.now());
					currentObject.setInputUser(this.getLoggedUser().getUserCode());
					Ajax.updateRow(dataTable, i);
				}
			}

			dataTable.setRowIndex(currentPos);

			dataTable.setRowIndex(currentPos);

			// Set the previous status Id to a invalid value
			this.setPrevStatusId(-1);

			// Set cancelFlag to false
			this.setToCancel(false);
		}
	}

	@Override
	public void changeNewDialogHeader() {
		if (this.isFromAddingRow()) {
			this.setDialogHeaderText("Add New Historic Row for Promotion Type");
		} else {
			this.setDialogHeaderText("Create new Promotion Type");
		}
	}

	@Override
	public void changeDeleteMessage() {
		this.setDeleteMessageDialog("Promotion type " + this.getSelectedHistoricData().getCode()
				+ " - Do you really want to delete historic period ["
				+ Formatter.localDateTimeToString(this.getSelectedHistoricData().getStartDate()) + ", "
				+ Formatter.localDateTimeToString(this.getSelectedHistoricData().getEndDate()) + "]? ");
	}

	@Override
	public void changeStatusMessage() {
		this.setCancelMessageDialog("Promotion type " + this.getSelectedHistoricData().getCode()
				+ " - Do you really want to set the status to cancel from historic period ["
				+ Formatter.localDateTimeToString(this.getSelectedHistoricData().getStartDate()) + ", "
				+ Formatter.localDateTimeToString(this.getSelectedHistoricData().getEndDate()) + "] onwards?");
	}

	@SuppressWarnings("finally")
	@Override
	public boolean splitRecords(DataTable dataTable, int row, Object newRow) {
		String message = "INSERT NEW DATA";
		String messageDetail = "";
		boolean error = false;
		boolean coverGap = false;
		CtPromotionType newObject, originalPreviousDataRow, previousDataRow, subsequentDataRow;

		try {

			newObject = (CtPromotionType) newRow;

			Integer totalRows = dataTable.getRowCount();

			// The previous row from new data is the current row on the data table
			previousDataRow = this.getBackupHistoricDataList().get(row);
			// Gets original values from previous row --> backup
			originalPreviousDataRow = (CtPromotionType) Utilities.deepClone(previousDataRow);

			// new historic version from existing object
			if (!this.rangeDateValidation(facesContext, externalContext, previousDataRow.getStartDate(),
					previousDataRow.getEndDate(), newObject.getStartDate(), newObject.getEndDate())) {
				// not valid dates
				error = true;
			} else {
				// validates other date condition
				if (newObject.getStartDate().isEqual(Formatter.stringToLocalDateTime(Formatter.DEFAULT_START_DATE))
						&& (row != 0)) {
					// new start date = minDate for a row different from first row ==> error
					messageDetail = "Error in dates - Only the first row can sets the start date to the minimum allowed date.";
					logger.info("Create promotion type: " + newObject.toString() + " - " + messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);
					error = true;

				}
				if (newObject.getEndDate().isEqual(Formatter.stringToLocalDateTime(Formatter.DEFAULT_END_DATE))
						&& row != (totalRows - 1)) {
					// new end date = maxDate for a row different from last row ==> error
					messageDetail = "Error in dates - Only the last row can sets the end date to the maximum allowed date.";
					logger.info("Create promotion type: " + newObject.toString() + " - " + messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);
					error = true;

				}

				if (!error) {
					// dates are OK

					if (row != totalRows - 1) {
						// Check if de data to insert is to cover a gap
						// Retrieve the subsequent record data
						subsequentDataRow = this.backupHistoricDataList.get(row + 1);

						if (previousDataRow.getEndDate().isEqual(newObject.getStartDate().minusDays(1))
								&& newObject.getEndDate().isEqual(subsequentDataRow.getStartDate().minusDays(1))) {
							// exceptional case: there is a gap between the records and the new record comes
							// to cover it
							// ==> inserts only the new record
							// ...currentSD ............ currentED.....subsequentSD ........... subsequentED
							// ...v .................... v.............v ...................... v
							// ...[-----currentValue----]..............[-----subsequentValue----]
							// ..........................[--newValue--]
							// ..........................^ .......... ^
							// .........................newSD ....... newED

							promotionTypeEJB.insertNewHistoricDataRecord(newObject);

							coverGap = true;
						}
					}

					if (!coverGap) {
						// normal case: the new record and the exist record are consecutives or overlaps

						if ((newObject.getEndDate().isEqual(previousDataRow.getStartDate()))
								|| (newObject.getEndDate().isBefore(previousDataRow.getStartDate()))) {
							// .............currentSD ............ currentED
							// .............v ................... v
							// .............[-----currentValue----]
							// [--newValue--]]
							// ^ ......... ^^
							// newSD ..... newED
							if (row == 0) {
								// first row ==> can be a record before the first record

								if (previousDataRow.getStartDate().isEqual(newObject.getEndDate().plusDays(1))) {
									// the current record not to be modify ==> inserts only the new record <p>
									// ..............currentSD ............ currentED <p>
									// ..............v ................... v <p>
									// ..............[-----currentValue----] <p>
									// [--newValue--] <p>
									// ^ .......... ^ <p>
									// newSD ..... newED <p>

									promotionTypeEJB.insertNewHistoricDataRecord(newObject);
								} else {
									if (newObject.getEndDate().isEqual(previousDataRow.getStartDate())) {
										// [current start date, current end date] <p>
										// becomes to: <p>
										// [new start date, new end date] <p>
										// [new end date + 1, current end date] <p>

										// ....currentSD'=newED+1 ............ currentED <p>
										// ............. v ................... v <p>
										// ..............[-----currentValue----] <p>
										// [--newValue--] <p>
										// ^ .......... ^ <p>
										// newS ....... newED <p>

										// set first section of the record with the new value
										promotionTypeEJB.insertNewHistoricDataRecord(newObject);

										// delete the original record (to eliminate overlapping)
										promotionTypeEJB.deleteData(originalPreviousDataRow);

										// set the modified values
										previousDataRow.setModifUser(this.loggedUser.getUserCode());
										previousDataRow.setModifDate(LocalDateTime.now());
										// set second section of the record with the original value (except
										// dates)
										previousDataRow.setStartDate(newObject.getEndDate().plusDays(1));

										promotionTypeEJB.updateHistoricDataRecord(previousDataRow);

									} else {
										// no consecutive records ==> error
										messageDetail = "Error in dates - The new and current dates are not consecutives.";
										logger.info("Create promotion type: " + newObject.toString() + " - "
												+ messageDetail);
										this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO,
												message, messageDetail);
										error = true;
									}
								}

							} else {
								// not the first row ==> not allowed
								messageDetail = "Error in dates - The new end date can not be less than current start date.";
								logger.info("Create promotion type: " + newObject.toString() + " - " + messageDetail);
								this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
										messageDetail);
								error = true;
							}
						} else {
							if (newObject.getStartDate().isEqual(previousDataRow.getStartDate())) {
								// ..............currentSD .................. currentED <p>
								// ..............v ........................... v <p>
								// ..............[-----------------------------] <p>
								// ..............[-----------] <p>
								// ..............^ ......... ^ <p>
								// ..............newSD ..... newED <p>
								// becomes to: <p>
								// ..................currentSD'=newED+1 ....... currentED <p>
								// ...........................v ............... v <p>
								// ...........................[--.currentValue--] <p>
								// .............[--newValue--] <p>
								// .............^ .......... ^ <p>
								// .............newSD ...... newED <p>

								// delete the original record (to eliminate overlapping)
								promotionTypeEJB.deleteData(originalPreviousDataRow);

								// split the record --> set first section of the record with the new value
								previousDataRow = (CtPromotionType) Utilities.deepClone(newObject);
								previousDataRow.setInputDate(LocalDateTime.now());
								previousDataRow.setInputUser(this.getLoggedUser().getUserCode());

								promotionTypeEJB.updateHistoricDataRecord(previousDataRow);

								// split the record --> set second section of the record with the original value
								// (except dates)
								previousDataRow = (CtPromotionType) Utilities.deepClone(originalPreviousDataRow);
								// set the modified values
								previousDataRow.setModifUser(this.loggedUser.getUserCode());
								previousDataRow.setModifDate(LocalDateTime.now());
								// set the new start date
								previousDataRow.setStartDate(newObject.getEndDate().plusDays(1));
								promotionTypeEJB.updateHistoricDataRecord(previousDataRow);

							} else {
								if (newObject.getEndDate().isEqual(previousDataRow.getEndDate())) {
									// .............currentSD .................. currentED <p>
									// .............v ........................... v <p>
									// .............[-----------------------------] <p>
									// ...............................[-----------] <p>
									// ...............................^ ......... ^ <p>
									// ...............................newSD ..... newED <p>
									// becomes to: <p>
									// .......currentSD........... currentED'=newSD-1 <p>
									// .............v .............. v <p>
									// .............[--currentValue--] <p>
									// ...............................[--newValue--] <p>
									// ...............................^ .......... ^ <p>
									// ...............................newSD ...... newED <p>

									// split the record --> set first section of the record with the original
									// value
									// (except dates)

									// delete the original record (to eliminate overlapping)
									promotionTypeEJB.deleteData(originalPreviousDataRow);

									// set the modified values
									previousDataRow.setModifUser(this.loggedUser.getUserCode());
									previousDataRow.setModifDate(LocalDateTime.now());
									// set the new endDate
									previousDataRow.setEndDate(newObject.getStartDate().minusDays(1));
									promotionTypeEJB.updateHistoricDataRecord(previousDataRow);

									// split the record --> set second section of the record with the new value
									previousDataRow = (CtPromotionType) Utilities.deepClone(newObject);
									previousDataRow.setInputDate(LocalDateTime.now());
									previousDataRow.setInputUser(this.getLoggedUser().getUserCode());
									promotionTypeEJB.updateHistoricDataRecord(previousDataRow);

								} else {
									// ........currentSD ..................................... currentED <p>
									// .........v ............................................. v <p>
									// .........[-----------------------------------------------] <p>
									// .....................[-----------] <p>
									// .....................^ ......... ^
									// .....................newSD ..... newED <p>
									// becomes to: <p>
									// ....currentSD............ currentED'=newSD-1 <p>
									// .........v .............. v <p>
									// .........[--currentValue--] <p>
									// ...........................[--newValue--] <p>
									// ...........................^ .......... ^ <p>
									// ...........................newSD. ..... newED <p>
									// .........................................[--currentValue--] <p>
									// .........................................^ .............. ^ <p>
									// ......................................otherSD=newED+1 ...
									// otherED=currentED <p>
									//

									// delete the original record (to eliminate overlapping)
									promotionTypeEJB.deleteData(originalPreviousDataRow);

									// split the record --> set first section of the record with the original
									// value
									// (except dates)
									// set the modified values
									previousDataRow.setModifUser(this.loggedUser.getUserCode());
									previousDataRow.setModifDate(LocalDateTime.now());
									// set the new endDate
									previousDataRow.setEndDate(newObject.getStartDate().minusDays(1));
									promotionTypeEJB.updateHistoricDataRecord(previousDataRow);

									// split the record --> set second section of the record with the new value
									previousDataRow = (CtPromotionType) Utilities.deepClone(newObject);
									previousDataRow.setInputDate(LocalDateTime.now());
									previousDataRow.setInputUser(this.getLoggedUser().getUserCode());
									promotionTypeEJB.updateHistoricDataRecord(previousDataRow);

									// split the record --> set third section of the record with the original
									// values
									// (except dates)
									previousDataRow = (CtPromotionType) Utilities.deepClone(originalPreviousDataRow);
									// set the modified values
									previousDataRow.setModifUser(this.loggedUser.getUserCode());
									previousDataRow.setModifDate(LocalDateTime.now());
									// set the new startDate and endDate
									previousDataRow.setStartDate(newObject.getEndDate().plusDays(1));
									previousDataRow.setEndDate(originalPreviousDataRow.getEndDate());
									promotionTypeEJB.updateHistoricDataRecord(previousDataRow);

								}
							}

						}
					}

				}
			}

		} catch (EJBException e) {
			error = true;
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwDataAccessException")) {
				messageDetail = "DATA ACCES ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			} else if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwParseException")) {
				messageDetail = "PARSE ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			} else {
				messageDetail = "ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);
			}

		} catch (Exception e) {
			error = true;
			messageDetail = "ERROR - " + e.getMessage();
			logger.fatal(messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);
		} finally {
			return error;
		}

	}

	@Override
	public void changeSearchDataTableTitle() {
		if (this.isHistoricSearchDataCriteria()) {
			this.setSearchDataTableTitle(
					"RESULT DATA FOR HISTORIC SEARCH - Click on row button to manage the historic records of the promotion type");
		} else {
			this.setSearchDataTableTitle(
					"RESULT DATA FOR SEARCH DATE: " + Formatter.localDateTimeToString(this.getSearchDate())
							+ " - Click on row button to manage the historic records of the promotion type");
		}

	}
}