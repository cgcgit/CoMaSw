/*
    CoMaSw - Contract Management Software is a software developed for 
    the final academic project of the Universidade da Coruña (UDC).

    Copyright (C) 2022  Catarina García Cal (catarina.garcia.cal@udc.es)

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.

*/

package com.comasw.viewController.instance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
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

import com.comasw.ejb.instance.FeeEJBLocal;
import com.comasw.ejb.instance.ProductEJBLocal;
import com.comasw.ejb.instance.ServiceEJBLocal;
import com.comasw.ejb.parameterization.ApplicationLevelEJBLocal;
import com.comasw.generalClass.RelatedInstance;
import com.comasw.interfaces.IInstanceTable;
import com.comasw.model.tables.pojos.ItFee;
import com.comasw.model.tables.pojos.ItProduct;
import com.comasw.model.tables.pojos.ItService;
import com.comasw.model.tables.pojos.VwFeeInstance;
import com.comasw.model.tables.pojos.VwProductInstance;
import com.comasw.model.tables.pojos.VwServiceInstance;
import com.comasw.model.tables.pojos.VwUsers;
import com.comasw.utilities.Formatter;
import com.comasw.utilities.Utilities;

@Named
@ViewScoped
public class FeeController extends RelatedInstance<VwFeeInstance, ItFee, VwProductInstance, VwServiceInstance>
		implements Serializable, IInstanceTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5376900161042663504L;

	Logger logger = (Logger) LogManager.getLogger(FeeController.class);

	@Inject
	private ExternalContext externalContext;
	@Inject
	private FacesContext facesContext;

	@EJB
	private ServiceEJBLocal serviceEJB;

	@EJB
	private ProductEJBLocal productEJB;

	@EJB
	private ApplicationLevelEJBLocal applicationLevelEJB;

	@EJB
	private FeeEJBLocal feeEJB;

	// ---- SEARCH CRITERIA ----\\

	private Integer searchFeeId;

	private Integer searchFeeTypeId;

	private String searchFeeCode;

	private Integer searchServiceId;

	private Integer searchServiceTypeId;

	private String searchServiceNr;

	private Integer searchProductId;

	private Integer searchProductTypeId;

	private Integer searchAccountId;

	private String searchAccountIdentityCard;

	private String searchContractNr;

	private Integer searchCustomerId;

	private String searchCustomerIdentityCard;

	private boolean includeCanceledDataFlag;

	private boolean applicationLevelParentProdFlag;

	/** lists for the parent search data for create new form **/

	/**
	 * Search criteria for the new form
	 */

	private Integer searchServiceIdForNew;

	private Integer searchServiceTypeIdForNew;

	private String searchServiceNrForNew;

	private Integer searchProductIdForNew;

	private Integer searchProductTypeIdForNew;

	private String searchContractNrForNew;

	private Integer searchAccountIdForNew;

	private String searchAccountIdentityCardForNew;

	private Integer searchCustomerIdForNew;

	private String searchCustomerIdentityCardForNew;

	private boolean searchProdFlagForNew;

	private boolean applicationLevelProdFlagForNew;

	/**
	 * For new data - if is true --> copy the personal, address and bank data from
	 * parente customer
	 */
	private boolean copyDataFromTypeDefinitionFlag;

	/**
	 * List of candidate Fee Types for the new instance
	 */
	private List<SelectItem> feeTypeItemListForNew;

	// --------------------
	// GETTERS AND SETTERS
	// -------------------

	/**
	 * @return the searchFeeId
	 */
	public Integer getSearchFeeId() {
		return searchFeeId;
	}

	/**
	 * @param searchFeeId the searchFeeId to set
	 */
	public void setSearchFeeId(Integer searchFeeId) {
		this.searchFeeId = searchFeeId;
	}

	/**
	 * @return the searchFeeTypeId
	 */
	public Integer getSearchFeeTypeId() {
		return searchFeeTypeId;
	}

	/**
	 * @param searchFeeTypeId the searchFeeTypeId to set
	 */
	public void setSearchFeeTypeId(Integer searchFeeTypeId) {
		this.searchFeeTypeId = searchFeeTypeId;
	}

	/**
	 * @return the searchFeeCode
	 */
	public String getSearchFeeCode() {
		return searchFeeCode;
	}

	/**
	 * @param searchFeeCode the searchFeeCode to set
	 */
	public void setSearchFeeCode(String searchFeeCode) {
		this.searchFeeCode = searchFeeCode;
	}

	/**
	 * @return the searchServiceId
	 */
	public Integer getSearchServiceId() {
		return searchServiceId;
	}

	/**
	 * @param searchServiceId the searchServiceId to set
	 */
	public void setSearchServiceId(Integer searchServiceId) {
		this.searchServiceId = searchServiceId;
	}

	/**
	 * @return the searchServiceTypeId
	 */
	public Integer getSearchServiceTypeId() {
		return searchServiceTypeId;
	}

	/**
	 * @param searchServiceTypeId the searchServiceTypeId to set
	 */
	public void setSearchServiceTypeId(Integer searchServiceTypeId) {
		this.searchServiceTypeId = searchServiceTypeId;
	}

	/**
	 * @return the searchServiceNr
	 */
	public String getSearchServiceNr() {
		return searchServiceNr;
	}

	/**
	 * @param searchServiceNr the searchServiceNr to set
	 */
	public void setSearchServiceNr(String searchServiceNr) {
		this.searchServiceNr = searchServiceNr;
	}

	/**
	 * @return the searchProductId
	 */
	public Integer getSearchProductId() {
		return searchProductId;
	}

	/**
	 * @param searchProductId the searchProductId to set
	 */
	public void setSearchProductId(Integer searchProductId) {
		this.searchProductId = searchProductId;
	}

	/**
	 * @return the searchProductTypeId
	 */
	public Integer getSearchProductTypeId() {
		return searchProductTypeId;
	}

	/**
	 * @param searchProductTypeId the searchProductTypeId to set
	 */
	public void setSearchProductTypeId(Integer searchProductTypeId) {
		this.searchProductTypeId = searchProductTypeId;
	}

	/**
	 * @return the searchAccountId
	 */
	public Integer getSearchAccountId() {
		return searchAccountId;
	}

	/**
	 * @param searchAccountId the searchAccountId to set
	 */
	public void setSearchAccountId(Integer searchAccountId) {
		this.searchAccountId = searchAccountId;
	}

	/**
	 * @return the searchAccountIdentityCard
	 */
	public String getSearchAccountIdentityCard() {
		return searchAccountIdentityCard;
	}

	/**
	 * @param searchAccountIdentityCard the searchAccountIdentityCard to set
	 */
	public void setSearchAccountIdentityCard(String searchAccountIdentityCard) {
		this.searchAccountIdentityCard = searchAccountIdentityCard;
	}

	/**
	 * @return the searchContractNr
	 */
	public String getSearchContractNr() {
		return searchContractNr;
	}

	/**
	 * @param searchContractNr the searchContractNr to set
	 */
	public void setSearchContractNr(String searchContractNr) {
		this.searchContractNr = searchContractNr;
	}

	/**
	 * @return the searchCustomerId
	 */
	public Integer getSearchCustomerId() {
		return searchCustomerId;
	}

	/**
	 * @param searchCustomerId the searchCustomerId to set
	 */
	public void setSearchCustomerId(Integer searchCustomerId) {
		this.searchCustomerId = searchCustomerId;
	}

	/**
	 * @return the searchCustomerIdentityCard
	 */
	public String getSearchCustomerIdentityCard() {
		return searchCustomerIdentityCard;
	}

	/**
	 * @param searchCustomerIdentityCard the searchCustomerIdentityCard to set
	 */
	public void setSearchCustomerIdentityCard(String searchCustomerIdentityCard) {
		this.searchCustomerIdentityCard = searchCustomerIdentityCard;
	}

	/**
	 * @return the includeCanceledDataFlag
	 */
	public boolean isIncludeCanceledDataFlag() {
		return includeCanceledDataFlag;
	}

	/**
	 * @param includeCanceledDataFlag the includeCanceledDataFlag to set
	 */
	public void setIncludeCanceledDataFlag(boolean includeCanceledDataFlag) {
		this.includeCanceledDataFlag = includeCanceledDataFlag;
	}

	/**
	 * @return the applicationLevelParentProdFlag
	 */
	public boolean isApplicationLevelParentProdFlag() {
		return applicationLevelParentProdFlag;
	}

	/**
	 * @param applicationLevelParentProdFlag the applicationLevelParentProdFlag to
	 *                                       set
	 */
	public void setApplicationLevelParentProdFlag(boolean applicationLevelParentProdFlag) {
		this.applicationLevelParentProdFlag = applicationLevelParentProdFlag;
	}

	/**
	 * @return the searchServiceIdForNew
	 */
	public Integer getSearchServiceIdForNew() {
		return searchServiceIdForNew;
	}

	/**
	 * @param searchServiceIdForNew the searchServiceIdForNew to set
	 */
	public void setSearchServiceIdForNew(Integer searchServiceIdForNew) {
		this.searchServiceIdForNew = searchServiceIdForNew;
	}

	/**
	 * @return the searchServiceTypeIdForNew
	 */
	public Integer getSearchServiceTypeIdForNew() {
		return searchServiceTypeIdForNew;
	}

	/**
	 * @param searchServiceTypeIdForNew the searchServiceTypeIdForNew to set
	 */
	public void setSearchServiceTypeIdForNew(Integer searchServiceTypeIdForNew) {
		this.searchServiceTypeIdForNew = searchServiceTypeIdForNew;
	}

	/**
	 * @return the searchServiceNrForNew
	 */
	public String getSearchServiceNrForNew() {
		return searchServiceNrForNew;
	}

	/**
	 * @param searchServiceNrForNew the searchServiceNrForNew to set
	 */
	public void setSearchServiceNrForNew(String searchServiceNrForNew) {
		this.searchServiceNrForNew = searchServiceNrForNew;
	}

	/**
	 * @return the searchProductIdForNew
	 */
	public Integer getSearchProductIdForNew() {
		return searchProductIdForNew;
	}

	/**
	 * @param searchProductIdForNew the searchProductIdForNew to set
	 */
	public void setSearchProductIdForNew(Integer searchProductIdForNew) {
		this.searchProductIdForNew = searchProductIdForNew;
	}

	/**
	 * @return the searchProductTypeIdForNew
	 */
	public Integer getSearchProductTypeIdForNew() {
		return searchProductTypeIdForNew;
	}

	/**
	 * @param searchProductTypeIdForNew the searchProductTypeIdForNew to set
	 */
	public void setSearchProductTypeIdForNew(Integer searchProductTypeIdForNew) {
		this.searchProductTypeIdForNew = searchProductTypeIdForNew;
	}

	/**
	 * @return the searchContractNrForNew
	 */
	public String getSearchContractNrForNew() {
		return searchContractNrForNew;
	}

	/**
	 * @param searchContractNrForNew the searchContractNrForNew to set
	 */
	public void setSearchContractNrForNew(String searchContractNrForNew) {
		this.searchContractNrForNew = searchContractNrForNew;
	}

	/**
	 * @return the searchAccountIdForNew
	 */
	public Integer getSearchAccountIdForNew() {
		return searchAccountIdForNew;
	}

	/**
	 * @param searchAccountIdForNew the searchAccountIdForNew to set
	 */
	public void setSearchAccountIdForNew(Integer searchAccountIdForNew) {
		this.searchAccountIdForNew = searchAccountIdForNew;
	}

	/**
	 * @return the searchAccountIdentityCardForNew
	 */
	public String getSearchAccountIdentityCardForNew() {
		return searchAccountIdentityCardForNew;
	}

	/**
	 * @param searchAccountIdentityCardForNew the searchAccountIdentityCardForNew to
	 *                                        set
	 */
	public void setSearchAccountIdentityCardForNew(String searchAccountIdentityCardForNew) {
		this.searchAccountIdentityCardForNew = searchAccountIdentityCardForNew;
	}

	/**
	 * @return the searchCustomerIdForNew
	 */
	public Integer getSearchCustomerIdForNew() {
		return searchCustomerIdForNew;
	}

	/**
	 * @param searchCustomerIdForNew the searchCustomerIdForNew to set
	 */
	public void setSearchCustomerIdForNew(Integer searchCustomerIdForNew) {
		this.searchCustomerIdForNew = searchCustomerIdForNew;
	}

	/**
	 * @return the searchCustomerIdentityCardForNew
	 */
	public String getSearchCustomerIdentityCardForNew() {
		return searchCustomerIdentityCardForNew;
	}

	/**
	 * @param searchCustomerIdentityCardForNew the searchCustomerIdentityCardForNew
	 *                                         to set
	 */
	public void setSearchCustomerIdentityCardForNew(String searchCustomerIdentityCardForNew) {
		this.searchCustomerIdentityCardForNew = searchCustomerIdentityCardForNew;
	}

	/**
	 * @return the searchProdFlagForNew
	 */
	public boolean isSearchProdFlagForNew() {
		return searchProdFlagForNew;
	}

	/**
	 * @param searchProdFlagForNew the searchProdFlagForNew to set
	 */
	public void setSearchProdFlagForNew(boolean searchProdFlagForNew) {
		this.searchProdFlagForNew = searchProdFlagForNew;
	}

	/**
	 * @return the applicationLevelProdFlagForNew
	 */
	public boolean isApplicationLevelProdFlagForNew() {
		return applicationLevelProdFlagForNew;
	}

	/**
	 * @param applicationLevelProdFlagForNew the applicationLevelProdFlagForNew to
	 *                                       set
	 */
	public void setApplicationLevelProdFlagForNew(boolean applicationLevelProdFlagForNew) {
		this.applicationLevelProdFlagForNew = applicationLevelProdFlagForNew;
	}

	/**
	 * @return the copyDataFromTypeDefinitionFlag
	 */
	public boolean isCopyDataFromTypeDefinitionFlag() {
		return copyDataFromTypeDefinitionFlag;
	}

	/**
	 * @param copyDataFromTypeDefinitionFlag the copyDataFromTypeDefinitionFlag to
	 *                                       set
	 */
	public void setCopyDataFromTypeDefinitionFlag(boolean copyDataFromTypeDefinitionFlag) {
		this.copyDataFromTypeDefinitionFlag = copyDataFromTypeDefinitionFlag;
	}

	/**
	 * @return the feeTypeItemListForNew
	 */
	public List<SelectItem> getFeeTypeItemListForNew() {
		return feeTypeItemListForNew;
	}

	/**
	 * @param feeTypeItemListForNew the feeTypeItemListForNew to set
	 */
	public void setFeeTypeItemListForNew(List<SelectItem> feeTypeItemListForNew) {
		this.feeTypeItemListForNew = feeTypeItemListForNew;
	}

	// -------------------
	// METHODS
	// -------------------

	public FeeController() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {

		if (this.getNewData() == null) {
			this.setNewData(new ItFee());
		}

		if (this.getSearchDate() == null) {
			this.setSearchDate(LocalDate.now().atStartOfDay());
		}

		if (this.getSearchDate() == null) {
			this.setSearchDate(LocalDate.now().atStartOfDay());
		}

		if (this.getDataList() == null) {
			this.setDataList(new ArrayList<VwFeeInstance>());
		}

		if (this.getFilteredDataList() == null) {
			this.setFilteredDataList(new ArrayList<VwFeeInstance>());
		}

		if (this.getSelectedData() == null) {
			this.setSelectedData(new VwFeeInstance());
		}

		if (this.getSelectedDataList() == null) {
			this.setSelectedDataList(new ArrayList<VwFeeInstance>());
		}

		if (this.getFilteredSelectedDataList() == null) {
			this.setFilteredSelectedDataList(new ArrayList<VwFeeInstance>());
		}

		if (this.getHistoricDataList() == null) {
			this.setHistoricDataList(new ArrayList<ItFee>());
		}

		if (this.getFilteredHistoricDataList() == null) {
			this.setFilteredHistoricDataList(new ArrayList<ItFee>());
		}

		if (this.getBackupHistoricDataList() == null) {
			this.setBackupHistoricDataList(new ArrayList<ItFee>());
		}

		if (this.getSelectedHistoricData() == null) {
			this.setSelectedHistoricData(new ItFee());
		}

		if (this.getParentOneSearchDataList() == null) {
			this.setParentOneSearchDataList(new ArrayList<VwProductInstance>());
		}

		if (this.getFilteredParentOneSearchDataList() == null) {
			this.setFilteredParentOneSearchDataList(new ArrayList<VwProductInstance>());
		}

		if (this.getSelectedParentOneSearchData() == null) {
			this.setSelectedParentOneSearchData(new VwProductInstance());
		}

		if (this.getParentTwoSearchDataList() == null) {
			this.setParentTwoSearchDataList(new ArrayList<VwServiceInstance>());
		}

		if (this.getFilteredParentTwoSearchDataList() == null) {
			this.setFilteredParentTwoSearchDataList(new ArrayList<VwServiceInstance>());
		}

		if (this.getSelectedParentTwoSearchData() == null) {
			this.setSelectedParentTwoSearchData(new VwServiceInstance());
		}

		if (this.getFeeTypeItemListForNew() == null) {
			this.loadEmptyFeeTypeItemListForNew();
		}

		if (this.getLoggedUser() == null) {
			this.setLoggedUser((VwUsers) externalContext.getSessionMap().get("applicationUser"));
		}
	}

	@Override
	public void changeStatus(ValueChangeEvent e) {
		// Integer oldStatusId = (Integer) e.getOldValue();
		Integer newStatusId = (Integer) e.getNewValue();
		Integer originalStatusId;

		// Gets the current User
		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
				.findComponent(HISTORIC_DATA_TABLE_ID);
		ItFee data = (ItFee) dataTable.getRowData();

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
	public void revertSubsequentCancelStatus() {
		DataTable dataTable;
		int currentPos, lastPos;
		ItFee currentObject;

		dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(HISTORIC_DATA_TABLE_ID);
		lastPos = dataTable.getRowCount() - 1;
		currentPos = this.getCurrentHistoricRow();

		if (this.isToCancel()) {

			// System.out.println("actualStatusId: " + currentUser.getStatusId());
			if (this.isFromAddingRow()) {
				// The old value was equal to the previous row
				currentObject = (ItFee) dataTable.getRowData();
				currentObject.setStatusId(((ItFee) this.backupHistoricDataList.get(currentPos - 1)).getStatusId());
				Ajax.updateRow(dataTable, currentPos);
			}

			for (int i = currentPos + 1; i <= lastPos; i++) {
				dataTable.setRowIndex(i);

				currentObject = (ItFee) dataTable.getRowData();
				if (!STATUS_ID_CANC.equals(currentObject.getStatusId())) {
					// the status of the row is not cancel ==> updates the status
					// and the modif values

					currentObject.setStatusId(((ItFee) this.backupHistoricDataList.get(i)).getStatusId());
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
	public void pushConfirmButtonChangeStatus() {
		String message = "CHANGE STATUS";
		String messageDetail = "";
		int i, currentPos, lastPos;
		boolean error = false;

		LocalDateTime cancelledDate;

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
						((ItFee) dataTable.getRowData()).setStatusId(STATUS_ID_CANC);
						Ajax.updateRow(dataTable, i);

					}

					dataTable.setRowIndex(currentPos);

					messageDetail = "Subsequent status change succesfully";
					logger.info(
							"Change status fee: " + this.getSelectedHistoricData().toString() + " - " + messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);
				}

				// set the cancelled date for all the records
				if (this.getSelectedHistoricData().getCancelledDate() == null) {
					cancelledDate = LocalDateTime.now();
					this.setCancelledDateChanged(true);
					// change status from subsequent rows
					for (i = 0; i <= lastPos; i++) {
						dataTable.setRowIndex(i);
						((ItFee) dataTable.getRowData()).setCancelledDate(cancelledDate);
						;
						Ajax.updateRow(dataTable, i);

					}
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
	public void changeNewDialogHeader() {
		if (this.isFromAddingRow()) {
			this.setDialogHeaderText("Add New Historic Row for Fee");
		} else {
			this.setDialogHeaderText("Create new Fee");
		}

	}

	@Override
	public void changeDeleteMessage() {
		this.setDeleteMessageDialog(
				"Fee " + this.getSelectedHistoricData().getCode() + " - Do you really want to delete historic period ["
						+ Formatter.localDateTimeToString(this.getSelectedHistoricData().getStartDate()) + ", "
						+ Formatter.localDateTimeToString(this.getSelectedHistoricData().getEndDate()) + "]? ");

	}

	@Override
	public void changeStatusMessage() {
		this.setCancelMessageDialog("Fee " + this.getSelectedHistoricData().getCode()
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
		ItFee newObject, originalPreviousDataRow, previousDataRow, subsequentDataRow;

		try {

			newObject = (ItFee) newRow;

			Integer totalRows = dataTable.getRowCount();

			// The previous row from new data is the current row on the data table
			previousDataRow = this.getBackupHistoricDataList().get(row);
			// Gets original values from previous row --> backup
			originalPreviousDataRow = (ItFee) Utilities.deepClone(previousDataRow);

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
					logger.info("Create fee: " + newObject.toString() + " - " + messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);
					error = true;

				}
				if (newObject.getEndDate().isEqual(Formatter.stringToLocalDateTime(Formatter.DEFAULT_END_DATE))
						&& row != (totalRows - 1)) {
					// new end date = maxDate for a row different from last row ==> error
					messageDetail = "Error in dates - Only the last row can sets the end date to the maximum allowed date.";
					logger.info("Create fee: " + newObject.toString() + " - " + messageDetail);
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

							feeEJB.insertNewHistoricDataRecord(newObject);

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

									feeEJB.insertNewHistoricDataRecord(newObject);
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
										feeEJB.insertNewHistoricDataRecord(newObject);

										// delete the original record (to eliminate overlapping)
										feeEJB.deleteData(originalPreviousDataRow);

										// set the modified values
										previousDataRow.setModifUser(this.loggedUser.getUserCode());
										previousDataRow.setModifDate(LocalDateTime.now());
										// set second section of the record with the original value (except
										// dates)
										previousDataRow.setStartDate(newObject.getEndDate().plusDays(1));

										feeEJB.updateHistoricDataRecord(previousDataRow);

									} else {
										// no consecutive records ==> error
										messageDetail = "Error in dates - The new and current dates are not consecutives.";
										logger.info("Create fee: " + newObject.toString() + " - " + messageDetail);
										this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO,
												message, messageDetail);
										error = true;
									}
								}

							} else {
								// not the first row ==> not allowed
								messageDetail = "Error in dates - The new end date can not be less than current start date.";
								logger.info("Create fee: " + newObject.toString() + " - " + messageDetail);
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
								feeEJB.deleteData(originalPreviousDataRow);

								// split the record --> set first section of the record with the new value
								previousDataRow = (ItFee) Utilities.deepClone(newObject);
								previousDataRow.setInputDate(LocalDateTime.now());
								previousDataRow.setInputUser(this.getLoggedUser().getUserCode());

								feeEJB.updateHistoricDataRecord(previousDataRow);

								// split the record --> set second section of the record with the original value
								// (except dates)
								previousDataRow = (ItFee) Utilities.deepClone(originalPreviousDataRow);
								// set the modified values
								previousDataRow.setModifUser(this.loggedUser.getUserCode());
								previousDataRow.setModifDate(LocalDateTime.now());
								// set the new start date
								previousDataRow.setStartDate(newObject.getEndDate().plusDays(1));
								feeEJB.updateHistoricDataRecord(previousDataRow);

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
									feeEJB.deleteData(originalPreviousDataRow);

									// set the modified values
									previousDataRow.setModifUser(this.loggedUser.getUserCode());
									previousDataRow.setModifDate(LocalDateTime.now());
									// set the new endDate
									previousDataRow.setEndDate(newObject.getStartDate().minusDays(1));
									feeEJB.updateHistoricDataRecord(previousDataRow);

									// split the record --> set second section of the record with the new value
									previousDataRow = (ItFee) Utilities.deepClone(newObject);
									previousDataRow.setInputDate(LocalDateTime.now());
									previousDataRow.setInputUser(this.getLoggedUser().getUserCode());
									feeEJB.updateHistoricDataRecord(previousDataRow);

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
									feeEJB.deleteData(originalPreviousDataRow);

									// split the record --> set first section of the record with the original
									// value
									// (except dates)
									// set the modified values
									previousDataRow.setModifUser(this.loggedUser.getUserCode());
									previousDataRow.setModifDate(LocalDateTime.now());
									// set the new endDate
									previousDataRow.setEndDate(newObject.getStartDate().minusDays(1));
									feeEJB.updateHistoricDataRecord(previousDataRow);

									// split the record --> set second section of the record with the new value
									previousDataRow = (ItFee) Utilities.deepClone(newObject);
									previousDataRow.setInputDate(LocalDateTime.now());
									previousDataRow.setInputUser(this.getLoggedUser().getUserCode());
									feeEJB.updateHistoricDataRecord(previousDataRow);

									// split the record --> set third section of the record with the original
									// values
									// (except dates)
									previousDataRow = (ItFee) Utilities.deepClone(originalPreviousDataRow);
									// set the modified values
									previousDataRow.setModifUser(this.loggedUser.getUserCode());
									previousDataRow.setModifDate(LocalDateTime.now());
									// set the new startDate and endDate
									previousDataRow.setStartDate(newObject.getEndDate().plusDays(1));
									previousDataRow.setEndDate(originalPreviousDataRow.getEndDate());
									feeEJB.updateHistoricDataRecord(previousDataRow);

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
		// TODO Auto-generated method stub

	}

	@Override
	public void onRowInit(RowEditEvent<?> event) {
		ItFee dataObject;
		String message, message_detail;

		message = "EDIT ROW";

		// Gets the object to modifyItAccount
		dataObject = (ItFee) event.getObject();

		// If we are editing a row, we must disabled all the other buttons
		this.setEditingMode(true);

		try {
			// The user was pushed the edit button
			message_detail = "Editing fee: " + dataObject.toString();
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
		ItFee dataObject;
		String message, messageDetail;
		boolean validation = false;
		ItFee originalDataObject;
		ItFee otherRecordDataObject;

		message = "SAVE EDIT ROW";

		// Retrieved the data that was modified
		dataObject = (ItFee) event.getObject();

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
									otherRecordDataObject = (ItFee) dataTable.getRowData();
									dataTable.setRowIndex(pos);

									feeEJB.updateHistoricDataRecord(otherRecordDataObject);
									// deletes the original data for this record
									otherRecordDataObject = this.backupHistoricDataList.get(pos - 1);
									feeEJB.deleteData(otherRecordDataObject);
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
									otherRecordDataObject = (ItFee) dataTable.getRowData();
									dataTable.setRowIndex(pos);
									feeEJB.updateHistoricDataRecord(otherRecordDataObject);
									// deletes the original data for this record
									otherRecordDataObject = this.backupHistoricDataList.get(pos + 1);
									feeEJB.deleteData(otherRecordDataObject);
								}
							}
						}
					}
				}

				// delete the original data of the record
				feeEJB.deleteData(originalDataObject);
				// update the current data record
				feeEJB.updateHistoricDataRecord(dataObject);

				// Check if the status was changed to cancel or if activeDateChanged --> if so,
				// we must update other rows
				if (this.isToCancel() || this.isActiveDateChanged() || this.isCancelledDateChanged()) {
					int i;
					if (this.isActiveDateChanged() || this.isCancelledDateChanged()) {
						// update all the data table
						for (i = 0; i <= lastRow; i++) {
							dataTable.setRowIndex(i);
							dataObject = (ItFee) dataTable.getRowData();
							// accountEJB.updateHistoricDataRecord(dataObject);
							feeEJB.updateData(dataObject);
						}
					} else { // only the subsequent rows
						for (i = pos + 1; i <= lastRow; i++) {
							dataTable.setRowIndex(i);
							dataObject = (ItFee) dataTable.getRowData();
							// accountEJB.updateHistoricDataRecord(dataObject);
							feeEJB.updateData(dataObject);
						}
					}

					logger.info("Updated the status to cancel for the subsequent rows");

				}

				// set the row index to the current position
				dataTable.setRowIndex(pos);

				// reload the list
				this.loadHistoricalDataList();

				// Evaluates if the data was by adding or update
				messageDetail = "The changes for fee " + dataObject.toString() + " has done";
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
		ItFee dataObject;
		String message, messageDetail;

		message = "CANCEL UPDATE ROW";

		// Retrieved the data that was modified
		dataObject = (ItFee) event.getObject();

		try {
			this.refreshHistoricDataTable();
			messageDetail = "The changes for fee " + dataObject.toString() + " was cancelled";
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
	public void pushDeleteRowButton() {
		String message, messageDetail;

		DataTable dataTable;
		ItFee currentData;

		message = "DELETE ROW";

		try {
			// Gets the current data
			dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
					.findComponent(HISTORIC_DATA_TABLE_ID);
			// pos = dataTable.getRowIndex();
			this.setCurrentHistoricRow(dataTable.getRowIndex());
			currentData = (ItFee) dataTable.getRowData();
			this.setSelectedHistoricData((ItFee) Utilities.deepClone(currentData));

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
		this.setFromAddingRow(false);
		// Set the default dates and input values for the new data

		if (this.getNewData() != null) {
			this.setNewData(null);
		}

		this.setNewData(new ItFee());
		this.getNewData().setStartDate(LocalDateTime.now());
		this.getNewData().setEndDate(Formatter.stringToLocalDateTime(Formatter.DEFAULT_END_DATE));
		this.getNewData().setInputUser(this.loggedUser.getUserCode());
		this.getNewData().setInputDate(LocalDateTime.now());
		if (!this.isFromAddingRow()) {
			this.getNewData().setStatusId(STATUS_ID_PENDING_INSTANCE);
		}

		this.setApplicationLevelProdFlagForNew(true);

		this.setSearchProductIdForNew(null);
		this.setSearchProductTypeIdForNew(null);

		this.setSearchServiceIdForNew(null);
		this.setSearchServiceTypeIdForNew(null);
		this.setSearchServiceNrForNew(null);

		this.setSearchContractNrForNew(null);

		this.setSearchAccountIdForNew(null);
		this.setSearchAccountIdentityCardForNew(null);

		this.setSearchCustomerIdForNew(null);
		this.setSearchCustomerIdentityCardForNew(null);

		// Change the header to the new dialog
		this.changeNewDialogHeader();

		PrimeFaces.current().executeScript("PF('newParentPanelWidget').unselectAll();");

		PrimeFaces.current().executeScript("PF('createNewDialogWidget').show();");

	}

	@Override
	public void pushConfirmButtonCreateNewDialog() {
		String message = "INSERT NEW DATA";
		String messageDetail = "";
		boolean error = false;
		Integer row = this.getCurrentHistoricRow();
		Integer id;

		try {
			if (this.objectValidation(this.getNewData())) {
				if (this.isFromAddingRow()) {
					// Gets the table
					DataTable dataTable = (DataTable) facesContext.getViewRoot().findComponent(HISTORIC_DATA_TABLE_ID);
					error = splitRecords(dataTable, row, this.getNewData());
				} else {
					// create a new object
					id = feeEJB.insertData(this.getNewData());
					VwFeeInstance object = feeEJB.findInstanceViewWithParameters(
							Optional.ofNullable(this.getSearchDate()), true, Optional.ofNullable(id), Optional.empty(),
							Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
							Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
							Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty())
							.get(0);

					messageDetail = "Data saves succesfully";
					logger.info("Create service: " + this.getNewData().toString() + " - " + messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);

					this.setSelectedData(object);
					this.getSelectedDataList().clear();
					this.getSelectedDataList().add(object);
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
					messageDetail = "Shown data for product: ";
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
			this.setFromAddingRow(false);
			this.refreshHistoricDataTable();
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
					ItFee previousRecord = (ItFee) dataTable.getRowData();
					ItFee previousRecordOriginalData = (ItFee) Utilities.deepClone(previousRecord);

					// Subsequent row data
					dataTable.setRowIndex(currentPos + 1);
					ItFee subsequentRecord = (ItFee) dataTable.getRowData();

					// Set the endDate of the previows record to the startDate minus one date of the
					// subsequent record
					previousRecord.setEndDate(subsequentRecord.getStartDate().minusDays(1));
					previousRecord.setModifDate(LocalDateTime.now());
					previousRecord.setModifUser(this.getLoggedUser().getUserCode());

					// delete the selected data
					feeEJB.deleteData(this.getSelectedHistoricData());

					// delete the original previous record (to eliminate overlaps)
					feeEJB.deleteData(previousRecordOriginalData);

					// Update the previous record with the new endDate
					feeEJB.updateHistoricDataRecord(previousRecord);

					messageDetail = "Data deletes succesfully";
					logger.info("Delete fee: " + this.getSelectedHistoricData().toString() + " - " + messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);

					logger.info("Update the previous record end date sucessfully");
				} else {

					// delete the selected data
					feeEJB.deleteData(this.getSelectedHistoricData());

					messageDetail = "Data deletes succesfully";
					logger.info("Delete fee: " + this.getSelectedHistoricData().toString() + " - " + messageDetail);
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
		String message, messageDetail;
		ItFee objectToValidate;
		boolean validation = true;

		LocalDateTime minDate = Formatter.stringToLocalDateTime("01/01/1900");
		LocalDateTime maxDate = Formatter.stringToLocalDateTime("31/12/9999");

		if (this.isFromAddingRow()) {
			message = "ADD NEW FEE ROW VALIDATION";
		} else {
			if (this.isEditingMode()) {
				message = "MODIFY FEE VALIDATION";
			} else {
				message = "NEW FEE VALIDATION";
			}
		}

		objectToValidate = (ItFee) dataObject;

		if (objectToValidate != null) {

			if (objectToValidate.getApplicationLevelId() == null) {
				messageDetail = "Error - The application level is null.";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else {
				if (objectToValidate.getParentInstanceId() == null) {
					messageDetail = "Error - The parent instance id is null.";
					logger.error(messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
							messageDetail);
					validation = false;
				} else {

					String applicationLevelCode = applicationLevelEJB
							.findDataByApplicationLevelId(objectToValidate.getApplicationLevelId()).getCode();
					if (applicationLevelCode != null) {
						if (applicationLevelCode.equalsIgnoreCase(FeeController.APPLICATION_LEVEL_PROD)) {
							List<ItProduct> list = productEJB
									.findDataByProductId(objectToValidate.getParentInstanceId());
							if (list.isEmpty()) {
								messageDetail = "Error - The parent product for id "
										+ objectToValidate.getParentInstanceId() + " not exists in the system.";
								logger.error(messageDetail);
								this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
										messageDetail);
								validation = false;
							}
						} else {
							if (applicationLevelCode.equalsIgnoreCase(FeeController.APPLICATION_LEVEL_SERV)) {
								List<ItService> list = serviceEJB
										.findDataByServiceId(objectToValidate.getParentInstanceId());
								if (list.isEmpty()) {
									messageDetail = "Error - The parent service for id "
											+ objectToValidate.getParentInstanceId() + " not exists in the system.";
									logger.error(messageDetail);
									this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR,
											message, messageDetail);
									validation = false;

								}
							}
						}
					} else {
						messageDetail = "Error - The application level code is null";
						logger.error(messageDetail);
						this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
								messageDetail);
						validation = false;
					}

				}
			}

			if (objectToValidate.getStartDate() == null) {
				messageDetail = "ERROR - The start date of the service can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else if (objectToValidate.getStartDate().compareTo(minDate) < 0) {
				messageDetail = "ERROR - The start date of the service can not be less than "
						+ Formatter.localDateTimeToString(minDate);
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else if (objectToValidate.getStartDate().compareTo(maxDate) > 0) {
				messageDetail = "ERROR - The start date of the service can not be greater than "
						+ Formatter.localDateTimeToString(maxDate);
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			}

			if (objectToValidate.getEndDate() == null) {
				messageDetail = "ERROR - The end date of the service can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else if (objectToValidate.getEndDate().compareTo(minDate) < 0) {
				messageDetail = "ERROR - The end date of the service can not be less than "
						+ Formatter.localDateTimeToString(minDate);
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			} else if (objectToValidate.getEndDate().compareTo(maxDate) > 0) {
				messageDetail = "ERROR - The end date of the service can not be greater than "
						+ Formatter.localDateTimeToString(maxDate);
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			}

			if (objectToValidate.getFeeTypeId() == null) {
				messageDetail = "ERROR - The fee type of the service can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			}

			if (objectToValidate.getStatusId() == null) {
				messageDetail = "ERROR - The status of the fee can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				validation = false;
			}

			if (this.isFromAddingRow()) {
				// Validation not neccesary for new instances (if some field is null it will be copied from the fee type) 

				if (objectToValidate.getCode() == null || objectToValidate.getCode().isEmpty()) {
					messageDetail = "ERROR - The code the fee can not be null";
					logger.error(messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
							messageDetail);
					validation = false;
				} else {
					objectToValidate.setCode(objectToValidate.getCode().trim().toUpperCase());
				}

				if (objectToValidate.getProrate() == null) {
					messageDetail = "ERROR - The prorated value of the fee can not be null";
					logger.error(messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
							messageDetail);
					validation = false;

				}

				if (objectToValidate.getPrice() == null
						|| objectToValidate.getPrice().compareTo(BigDecimal.valueOf(0)) < 0) {
					messageDetail = "ERROR - The price of the fee must be positive ";
					logger.error(messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
							messageDetail);
					validation = false;

				}
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
	public void loadDataList() {
		String message = "LOAD DATA";
		String messageDetail = "";
		String applicationLevelCode;
		if (this.getSearchDate() == null) {
			messageDetail = "The date value to search is null. Please fill the search date field";
			logger.error(message + " - " + messageDetail);
			FacesContext.getCurrentInstance().validationFailed();
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, message, messageDetail));
		} else {
			if (this.isApplicationLevelParentProdFlag()) {
				applicationLevelCode = FeeController.APPLICATION_LEVEL_PROD;
			} else {
				applicationLevelCode = FeeController.APPLICATION_LEVEL_SERV;
			}

			this.setDataList(feeEJB.findInstanceViewWithParameters(Optional.ofNullable(this.getSearchDate()),
					this.getIncludeCanceledDataFlag(), Optional.ofNullable(this.getSearchFeeId()),
					Optional.ofNullable(this.getSearchFeeTypeId()), Optional.ofNullable(this.getSearchFeeCode()),
					Optional.empty(), Optional.ofNullable(applicationLevelCode),
					Optional.ofNullable(this.getSearchServiceId()), Optional.ofNullable(this.getSearchServiceTypeId()),
					Optional.ofNullable(this.getSearchServiceNr()), Optional.ofNullable(this.getSearchProductId()),
					Optional.ofNullable(this.getSearchProductTypeId()), Optional.ofNullable(this.getSearchContractNr()),
					Optional.ofNullable(this.getSearchAccountId()),
					Optional.ofNullable(this.getSearchAccountIdentityCard()), Optional.empty(),
					Optional.ofNullable(this.getSearchCustomerId()),
					Optional.ofNullable(this.getSearchCustomerIdentityCard()), Optional.empty()));

			if (this.getDataList().isEmpty()) {
				logger.info("No data to show");

			} else {
				logger.info("Load data sucessful");
			}
		}

	}

	@Override
	public void resetFilterDataTable() {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dataTableWidget').clearFilters()");

	}

	@Override
	public void refreshDataTable() {
		this.resetFilterDataTable();
		this.loadDataList();
		Ajax.update(DATA_TABLE_ID);

	}

	@Override
	public void setInitVariablesToDefault() {
		this.setEditingMode(false);
		this.setSearchDate(LocalDate.now().atStartOfDay());
		this.setFromAddingRow(false);
		this.setToCancel(false);
		this.setActiveDateChanged(false);
		this.setCancelledDateChanged(false);
		this.setPrevStatusId(-1);
		this.setShowSelectedData(false);
		// this.setCreateNewContractFlag(true);
		this.setIncludeCanceledDataFlag(true);
		this.setApplicationLevelParentProdFlag(true);
		this.setApplicationLevelProdFlagForNew(true);

	}

	@Override
	public void setControlVariablesToDefault() {
		this.setInitVariablesToDefault();

	}

	@Override
	public void loadHistoricalDataList() {
		Integer id;
		if (this.getSelectedData() == null) {
			logger.error("The fee select is null");
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, "LOAD HISTORIC DATA",
					"The fee select is null");
		} else {
			id = this.getSelectedData().getFeeId();
			this.setHistoricDataList(feeEJB.findDataByFeeId(id));
			if (this.getHistoricDataList().isEmpty()) {
				logger.info("No historical data data to show for fee id " + id);

			} else {
				logger.info("Load historical data sucessful for fee id " + id);
				System.out.println("datalist: " + historicDataList.toString());
			}
		}
	}

	@Override
	public void pushSearchButton() {
		String message = "SEARCH DATA";
		String messageDetail = "";

		if (this.getSearchDate() == null) {
			messageDetail = "The date value to search is null. Please fill the search date field";
			logger.error(message + " - " + messageDetail);
			FacesContext.getCurrentInstance().validationFailed();
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, message, messageDetail));
		} else {
			this.loadDataList();
			if (this.getDataList().isEmpty()) {
				messageDetail = "No data to show for search date:" + Formatter.localDateTimeToString(searchDate);
				logger.info(message + " - " + messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);

			} else {
				this.resetFilterDataTable();
				PrimeFaces.current().executeScript("PF('searchListWidget').show();");
				// Ajax.update(SEARCH_DATA_TABLE_ID);

				messageDetail = "Shown data for the search date:" + Formatter.localDateTimeToString(searchDate);
				logger.info(message + " - " + messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);
			}

		}
	}

	@Override
	public void pushAddNewRowButton() {
		String message, messageDetail;
		DataTable dataTable;
		ItFee currentData = null;

		message = "ADD ROW";

		try {

			// Store the current data
			Utilities.copyGenericList(this.historicDataList, this.backupHistoricDataList);

			// Gets the current data
			dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
					.findComponent(HISTORIC_DATA_TABLE_ID);
			// pos = dataTable.getRowIndex();
			this.setCurrentHistoricRow(dataTable.getRowIndex());
			currentData = (ItFee) dataTable.getRowData();
			this.setSelectedHistoricData((ItFee) Utilities.deepClone(currentData));

			this.setNewData(new ItFee());
			this.getNewData().from(currentData);

			if (this.getNewData().getParentInstanceId() != null && this.getNewData().getApplicationLevelId() != null) {

				this.loadFeeTypeItemListForParentNew(this.getNewData().getApplicationLevelId(),
						this.getNewData().getParentInstanceId());
				// Sets the fromAddingRow value to true
				this.setFromAddingRow(true);
				this.changeNewDialogHeader();

				PrimeFaces.current().executeScript("PF('createNewDialogWidget').show();");

			} else {
				messageDetail = "ERROR -  The parent instance id or the application level is null";
				logger.fatal(messageDetail);
				createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);

			}

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
	public void pushShowDetailRowButton() {
		String message = "SHOWN HISTORIC DATA";
		String messageDetail = "";

		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(DATA_TABLE_ID);

		// Gets the selected data
		this.setSelectedData((VwFeeInstance) dataTable.getRowData());

		if (this.getSelectedData() == null || this.getSelectedData().getFeeId() == null
				|| this.getSelectedData().getFeeId() == 0) {
			messageDetail = "The fee is null";
			logger.error(message + " - " + messageDetail);
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);

		} else {
			this.setShowSelectedData(true);
			this.getSelectedDataList().clear();
			this.getSelectedDataList().add(this.getSelectedData());

			this.refreshHistoricDataTable();

			messageDetail = "Shown data for fee: ";
			logger.info(message + " - " + messageDetail + this.getSelectedData().toString());
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
					messageDetail + this.getSelectedData().getCustomerId().toString());

			PrimeFaces.current().executeScript("PF('searchListWidget').hide();");
			PrimeFaces.current().executeScript("PF('multipleAccordionPanelWidget').selectAll();");

		}

	}

	@Override
	public void resetFilterHistoricDataTable() {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('historicTableWidget').clearFilters()");

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
	public void pushSearchParentButton() {
		String message = "SEARCH PRODUCT";
		String messageDetail = "";

		// Gets the data form
		if ((this.getSearchServiceIdForNew() == null || this.getSearchServiceIdForNew() == 0)
				&& (this.getSearchServiceTypeIdForNew() == null || this.getSearchServiceTypeIdForNew() == 0)
				&& (this.getSearchServiceNrForNew() == null || this.getSearchServiceNrForNew().isEmpty())
				&& (this.getSearchProductIdForNew() == null || this.getSearchProductIdForNew() == 0)
				&& (this.getSearchProductTypeIdForNew() == null || this.getSearchProductTypeIdForNew() == 0)
				&& (this.getSearchCustomerIdForNew() == null || this.getSearchCustomerIdForNew() == 0)
				&& (this.getSearchCustomerIdentityCardForNew() == null
						|| this.getSearchCustomerIdentityCardForNew().isEmpty())
				&& (this.getSearchContractNrForNew() == null || this.getSearchContractNrForNew().isEmpty())
				&& (this.getSearchAccountIdentityCardForNew() == null
						|| this.getSearchAccountIdentityCardForNew().isEmpty())
				&& (this.getSearchAccountIdForNew() == null || this.getSearchAccountIdForNew() == 0)) {
			messageDetail = "The fields for the search criteria are null";
			logger.error(message + " - " + messageDetail);
			createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			facesContext.validationFailed();

		} else {
			try {
				this.getParentOneSearchDataList().clear();
				this.getParentTwoSearchDataList().clear();

				if (this.isSearchProdFlagForNew()) {
					// Parent ==> Product
					this.setParentOneSearchDataList(
							productEJB.findInstanceViewWithParameters(Optional.ofNullable(this.getSearchDate()), true,
									Optional.ofNullable(this.getSearchProductIdForNew()),
									Optional.ofNullable(this.getSearchProductTypeIdForNew()), Optional.empty(),
									Optional.ofNullable(this.getSearchContractNrForNew()),
									Optional.ofNullable(this.getSearchAccountIdForNew()),
									Optional.ofNullable(this.getSearchAccountIdentityCardForNew()), Optional.empty(),
									Optional.ofNullable(this.getSearchCustomerIdForNew()),
									Optional.ofNullable(this.getSearchCustomerIdentityCardForNew()), Optional.empty()));

					PrimeFaces current = PrimeFaces.current();
					current.executeScript("PF('parentOneDataTableWidget').clearFilters()");

				} else {
					this.setParentTwoSearchDataList(
							serviceEJB.findInstanceViewWithParameters(Optional.ofNullable(this.getSearchDate()), true,
									Optional.ofNullable(this.getSearchServiceIdForNew()),
									Optional.ofNullable(this.getSearchServiceTypeIdForNew()),
									Optional.ofNullable(this.getSearchServiceNrForNew()), Optional.empty(),
									Optional.ofNullable(this.getSearchProductIdForNew()),
									Optional.ofNullable(this.getSearchProductTypeIdForNew()),
									Optional.ofNullable(this.getSearchContractNrForNew()),
									Optional.ofNullable(this.getSearchAccountIdForNew()),
									Optional.ofNullable(this.getSearchAccountIdentityCardForNew()), Optional.empty(),
									Optional.ofNullable(this.getSearchCustomerIdForNew()),
									Optional.ofNullable(this.getSearchCustomerIdentityCardForNew()), Optional.empty()));

					PrimeFaces current = PrimeFaces.current();
					current.executeScript("PF('parentTwoDataTableWidget').clearFilters()");

				}

			} catch (EJBException e) {
				Exception ne = (Exception) e.getCause();
				if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwDataAccessException")) {
					messageDetail = "DATA ACCES ERROR - " + ne.getMessage();
					logger.fatal(messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message,
							messageDetail);

				} else if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwParseException")) {
					messageDetail = "PARSE ERROR - " + ne.getMessage();
					logger.fatal(messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message,
							messageDetail);

				} else {
					messageDetail = "ERROR - " + ne.getMessage();
					logger.fatal(messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message,
							messageDetail);
				}

			} catch (Exception e) {
				messageDetail = "ERROR - " + e.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);
			}

		}

	}

	@Override
	public void addParentToInstanceRowButton() {

		String parentType, message, messageDetail;
		DataTable dataTable;
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		message = "ADD PARENT TO FEE";

		parentType = params.get("parent");

		if (parentType != null) {

			if (parentType.equalsIgnoreCase("ONE")) {
				dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
						.findComponent(PARENT_ONE_DATA_TABLE_ID);

				if (this.getSelectedParentOneSearchData() == null) {
					this.setSelectedParentOneSearchData(new VwProductInstance());
				}

				this.setSelectedParentOneSearchData((VwProductInstance) dataTable.getRowData());

				this.getNewData().setParentInstanceId(this.getSelectedParentOneSearchData().getProductId());

				this.setSearchServiceIdForNew(null);
				this.setSearchServiceTypeIdForNew(null);
				this.setSearchServiceNrForNew(null);

				this.setSearchProductIdForNew(this.getSelectedParentOneSearchData().getProductId());
				this.setSearchProductTypeIdForNew(this.getSelectedParentOneSearchData().getProductTypeId());

				this.setSearchContractNrForNew(this.getSelectedParentOneSearchData().getContractNumber());
				this.setSearchAccountIdForNew(this.getSelectedParentOneSearchData().getAccountId());
				this.setSearchAccountIdentityCardForNew(this.getSelectedParentOneSearchData().getAccountIdentityCard());

				this.setSearchCustomerIdentityCardForNew(
						this.getSelectedParentOneSearchData().getCustomerIdentityCard());
				this.setSearchCustomerIdForNew(this.getSelectedParentOneSearchData().getCustomerId());

				this.getNewData().setApplicationLevelId(applicationLevelEJB
						.findDataByCode(FeeController.APPLICATION_LEVEL_PROD).getApplicationLevelId());

				this.loadFeeTypeItemListForParentNew(this.getNewData().getApplicationLevelId(),
						this.getNewData().getParentInstanceId());

			} else {
				if (parentType.equalsIgnoreCase("TWO")) {
					dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
							.findComponent(PARENT_TWO_DATA_TABLE_ID);

					if (this.getSelectedParentTwoSearchData() == null) {
						this.setSelectedParentTwoSearchData(new VwServiceInstance());
					}

					this.setSelectedParentTwoSearchData((VwServiceInstance) dataTable.getRowData());

					this.getNewData().setParentInstanceId(this.getSelectedParentTwoSearchData().getServiceId());

					this.setSearchServiceIdForNew(this.getSelectedParentTwoSearchData().getServiceId());
					this.setSearchServiceTypeIdForNew(this.getSelectedParentTwoSearchData().getServiceTypeId());
					this.setSearchServiceNrForNew(this.getSelectedParentTwoSearchData().getServiceNumber());

					this.setSearchProductIdForNew(this.getSelectedParentTwoSearchData().getProductId());
					this.setSearchProductTypeIdForNew(this.getSelectedParentTwoSearchData().getProductTypeId());

					this.setSearchContractNrForNew(this.getSelectedParentTwoSearchData().getContractNumber());
					this.setSearchAccountIdForNew(this.getSelectedParentTwoSearchData().getAccountId());
					this.setSearchAccountIdentityCardForNew(
							this.getSelectedParentTwoSearchData().getAccountIdentityCard());

					this.setSearchCustomerIdentityCardForNew(
							this.getSelectedParentTwoSearchData().getCustomerIdentityCard());
					this.setSearchCustomerIdForNew(this.getSelectedParentTwoSearchData().getCustomerId());

					this.getNewData().setApplicationLevelId(applicationLevelEJB
							.findDataByCode(FeeController.APPLICATION_LEVEL_SERV).getApplicationLevelId());

					this.loadFeeTypeItemListForParentNew(this.getNewData().getApplicationLevelId(),
							this.getNewData().getParentInstanceId());

				} else {
					messageDetail = "ERROR - DATA PARENT NOT DETECTED";
					logger.fatal(messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message,
							messageDetail);
					FacesContext.getCurrentInstance().validationFailed();
				}
			}
		} else {
			messageDetail = "ERROR - NULL DATA PARENT";
			logger.fatal(messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);
			FacesContext.getCurrentInstance().validationFailed();
		}

		PrimeFaces.current().executeScript("PF('searchParentListWidget').hide();");
		// PrimeFaces.current().executeScript("PF('newParentPanelWidget').refresh();");

	}

	@Override
	public void changeCancelledDate(ValueChangeEvent e) {
		// Integer oldStatusId = (Integer) e.getOldValue();
		LocalDateTime newCancelledDate = (LocalDateTime) e.getNewValue();
		LocalDateTime originalCancelledDate;
		int i;

		// Gets the current User
		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
				.findComponent(HISTORIC_DATA_TABLE_ID);
		ItFee data = (ItFee) dataTable.getRowData();

		this.setSelectedHistoricData(data);

		// Gets the row of the current User
		String row = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("currentHistoricalRow");
		this.setCurrentHistoricRow(Integer.parseInt(row));

		// Gets the status Id previous to the edition of the row
		originalCancelledDate = this.getBackupHistoricDataList().get(this.getCurrentRow()).getActiveDate();

		if ((originalCancelledDate == null) || ((newCancelledDate == null) && !(originalCancelledDate == null))
				|| (!originalCancelledDate.isEqual(newCancelledDate))) {

			this.setCancelledDateChanged(true);

			// the active date was changed
			for (i = 0; i < dataTable.getRowCount(); i++) {
				dataTable.setRowIndex(i);
				((ItFee) dataTable.getRowData()).setActiveDate(newCancelledDate);
				;
				Ajax.updateRow(dataTable, i);
			}

		}
	}

	@Override
	public void changeActiveDate(ValueChangeEvent e) {
		// Integer oldStatusId = (Integer) e.getOldValue();
		LocalDateTime newActiveDate = (LocalDateTime) e.getNewValue();
		LocalDateTime originalActiveDate;
		int i;

		// Gets the current User
		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
				.findComponent(HISTORIC_DATA_TABLE_ID);
		ItFee data = (ItFee) dataTable.getRowData();

		this.setSelectedHistoricData(data);

		// Gets the row of the current User
		String row = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("currentHistoricalRow");
		this.setCurrentHistoricRow(Integer.parseInt(row));

		// Gets the status Id previous to the edition of the row
		originalActiveDate = this.getBackupHistoricDataList().get(this.getCurrentRow()).getActiveDate();

		if ((originalActiveDate == null) || ((newActiveDate == null) && !(originalActiveDate == null))
				|| (!originalActiveDate.isEqual(newActiveDate))) {

			this.setActiveDateChanged(true);

			// the active date was changed
			for (i = 0; i < dataTable.getRowCount(); i++) {
				dataTable.setRowIndex(i);
				((ItFee) dataTable.getRowData()).setActiveDate(newActiveDate);
				;
				Ajax.updateRow(dataTable, i);

			}

		}
	}

	/**
	 * To load the fee type list to create the new instance when the application
	 * level is changed If parent id or application level are not defined, the list
	 * is not load.
	 * 
	 * @param e
	 */
	public void changeApplicationLevelForNew(ValueChangeEvent e) {

		Integer applicationLevelId = (Integer) e.getNewValue();

		this.getNewData().setApplicationLevelId(applicationLevelId);

		if (this.getNewData().getParentInstanceId() != null && applicationLevelId != null) {
			this.loadFeeTypeItemListForParentNew(applicationLevelId, this.getNewData().getParentInstanceId());
		}

	}

	/**
	 * To load the fee type list to create the new instance when the parent id is
	 * changed. If parent id or application level are not defined, the list is not
	 * load.
	 * 
	 * @param e
	 */
	public void changeParentIdForNew(ValueChangeEvent e) {

		Integer parentId = (Integer) e.getNewValue();

		if (parentId != null && this.getNewData().getApplicationLevelId() != null) {
			this.loadFeeTypeItemListForParentNew(this.getNewData().getApplicationLevelId(), parentId);
		}

	}

	/**
	 * Method that load the fee type list according to application level and parent
	 * id
	 */
	public void loadFeeTypeItemListForParentNew(Integer applicationLevelId, Integer parentId) {
		String message, messageDetail, applicationCode;
		message = "LOAD FEE TYPE FOR PARENT INSTANCE";

		if (parentId != null && applicationLevelId != null) {
			applicationCode = applicationLevelEJB.findDataByApplicationLevelId(applicationLevelId).getCode();
			if (applicationCode.equalsIgnoreCase(FeeController.APPLICATION_LEVEL_PROD)) {
				List<ItProduct> list = productEJB.findDataByProductId(parentId);
				if (list != null && !list.isEmpty()) {
					this.getFeeTypeItemListForNew().clear();
					this.setFeeTypeItemListForNew(
							this.feeProductRelatedTypeSelectItems(list.get(0).getProductTypeId()));
				} else {
					this.loadEmptyFeeTypeItemListForNew();
				}
			} else {
				if (applicationCode.equalsIgnoreCase(FeeController.APPLICATION_LEVEL_SERV)) {
					List<ItService> list = serviceEJB.findDataByServiceId(parentId);
					if (list != null && !list.isEmpty()) {
						this.getFeeTypeItemListForNew().clear();
						this.setFeeTypeItemListForNew(
								this.feeServiceRelatedTypeSelectItems(list.get(0).getServiceTypeId()));
					} else {
						this.loadEmptyFeeTypeItemListForNew();
					}

				} else {
					messageDetail = "ERROR - Unexpected application level code (" + applicationCode + ")";
					logger.fatal(messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message,
							messageDetail);
					FacesContext.getCurrentInstance().validationFailed();
				}
			}
		}

	}

	/**
	 * Method that loads the empty list for the fee type
	 */
	public void loadEmptyFeeTypeItemListForNew() {

		if (this.getFeeTypeItemListForNew() == null) {
			this.setFeeTypeItemListForNew(new ArrayList<>());
		} else {
			this.getFeeTypeItemListForNew().clear();
		}

		SelectItem nullItem = new SelectItem();
		nullItem.setLabel("Select One... ");
		nullItem.setValue(null);
		this.getFeeTypeItemListForNew().add(nullItem);
	}

	/**
	 * Method than returns the feeItemTypeList for the view
	 * 
	 * @return the feeItemList for the view
	 */
	public List<SelectItem> feeTypeItemListForParentNew() {
		return this.getFeeTypeItemListForNew();

	}

}
