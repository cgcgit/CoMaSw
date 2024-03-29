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

package com.comasw.viewController.catalog.relationType;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
import com.comasw.model.tables.pojos.CtProductType;
import com.comasw.model.tables.pojos.VwPromotionProductType;
import com.comasw.model.tables.pojos.CtPromoProdType;
import com.comasw.model.tables.pojos.VwUsers;
import com.comasw.utilities.Formatter;
import com.comasw.ejb.catalog.relationType.ProductPromotionTypeEJBLocal;
import com.comasw.ejb.catalog.type.ProductTypeEJBLocal;
import com.comasw.ejb.catalog.type.PromotionTypeEJBLocal;
import com.comasw.ejb.parameterization.StatusEJBLocal;
import com.comasw.exception.CoMaSwDataAccessException;
import com.comasw.generalClass.SimpleHistoricRelation;
import com.comasw.interfaces.ISimpleHistoricRelationsTable;

@Named
@ViewScoped
/**
 * @author catuxa
 *
 */
public class ProductPromotionTypeController
		extends SimpleHistoricRelation<CtProductType, VwPromotionProductType, CtPromotionType>
		implements Serializable, ISimpleHistoricRelationsTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2872381274603389370L;

	Logger logger = (Logger) LogManager.getLogger(ProductServiceTypeController.class);

	protected static String ACTIVE_STATUS_CODE = dbDefinitions.getString("STATUS_CODE_ACT");

	String SEARCH_DATA_TABLE_ID = "form:accordionPanel:searchTable";

	String SELECTED_DATA_TABLE_ID = "form:accordionPanel:selectedTable";

	String RELATED_DATA_TABLE_ID = "form:accordionPanel:relatedTable";

	String CANDIDATE_DATA_TABLE_ID = "form:accordionPanel:candidateTable";

	@Inject
	private ExternalContext externalContext;
	@Inject
	private FacesContext facesContext;

	@EJB
	private ProductTypeEJBLocal productTypeEJB;

	@EJB
	private ProductPromotionTypeEJBLocal productPromotionTypeEJB;

	@EJB
	private PromotionTypeEJBLocal promotionTypeEJB;

	@EJB
	private StatusEJBLocal statusEJB;

	/**
	 * Selected main data
	 */
	
	private CtProductType injectSelectedData;

	/**
	 * Selected candidate data
	 */
	
	private CtPromotionType injectSelectedCandidateData;

	/**
	 * Selected related data
	 */
	
	private VwPromotionProductType injectSelectedRelatedData;

	// --------------------
	// GETTERS AND SETTERS
	// -------------------

	/**
	 * @return the injectSelectedData
	 */
	public CtProductType getInjectSelectedData() {
		return injectSelectedData;
	}

	/**
	 * @param injectSelectedData the selectedParentData to set
	 */
	public void setInjectSelectedData(CtProductType injectSelectedData) {
		this.injectSelectedData = injectSelectedData;
	}

	/**
	 * @return the injectSelectedCandidateData
	 */
	public CtPromotionType getInjectSelectedCandidateData() {
		return injectSelectedCandidateData;
	}

	/**
	 * @param injectSelectedCandidateData the selectedCandidateData to set
	 */
	public void setInjectSelectedCandidateData(CtPromotionType injectSelectedCandidateData) {
		this.injectSelectedCandidateData = injectSelectedCandidateData;
	}

	/**
	 * @return the injectSelectedRelatedData
	 */
	public VwPromotionProductType getInjectSelectedRelatedData() {
		return injectSelectedRelatedData;
	}

	/**
	 * @param selectedRelatedData the selectedRelatedData to set
	 */
	public void setInjectSelectedRelatedData(VwPromotionProductType injectSelectedRelatedData) {
		this.injectSelectedRelatedData = injectSelectedRelatedData;
	}

	// -------------------
	// METHODS
	// -------------------

	/**
	 * 
	 */
	public ProductPromotionTypeController() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {

		if (this.getSearchDate() == null) {
			this.setSearchDate(LocalDate.now().atStartOfDay());
		}

		if (this.getDataList() == null) {
			this.setDataList(new ArrayList<CtProductType>());
		}

		if (this.getFilteredDataList() == null) {
			this.setFilteredDataList(new ArrayList<CtProductType>());
		}

		if (this.getSelectedData() == null) {
			this.setSelectedData(new CtProductType());
		}

		if (this.getCandidateDataList() == null) {
			this.setCandidateDataList(new ArrayList<CtPromotionType>());
		}

		if (this.getFilteredCandidateDataList() == null) {
			this.setFilteredCandidateDataList(new ArrayList<CtPromotionType>());
		}

		if (this.getHistoricCandidateDataList() == null) {
			this.setHistoricCandidateDataList(new ArrayList<CtPromotionType>());
		}

		if (this.getFilteredHistoricCandidateDataList() == null) {
			this.setFilteredHistoricCandidateDataList(new ArrayList<CtPromotionType>());
		}

		if (this.getRelatedDataList() == null) {
			this.setRelatedDataList(new ArrayList<VwPromotionProductType>());
		}

		if (this.getFilteredRelatedDataList() == null) {
			this.setFilteredRelatedDataList(new ArrayList<VwPromotionProductType>());
		}

		if (this.getLoggedUser() == null) {
			this.setLoggedUser((VwUsers) externalContext.getSessionMap().get("applicationUser"));
		}
	}

	@Override
	public void loadDataList() {
		this.setDataList(productTypeEJB.findAllData());
		if (this.getDataList().isEmpty()) {
			logger.info("No parent data to show");

		} else {
			logger.info("Load parent data sucessful");
		}

	}

	@Override
	public void loadRelatedDataList() {
		String errorMessage;

		if ((this.getSelectedData() != null) && (this.getSelectedData().getProductTypeId() != null)
				&& (this.getSelectedData().getProductTypeId() != 0)) {
			if (this.isHistoricRelatedDataCriteria()) {
				this.setRelatedDataList(productPromotionTypeEJB
						.findHistoricRelatedEntityTypesView(this.getSelectedData().getProductTypeId()));
			} else {
				if (this.getSearchDate() == null) {
					logger.error("The search date is null");
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, "LOAD RELATED DATE",
							"The search date is null");
				} else {
					this.setRelatedDataList(productPromotionTypeEJB.findRelatedEntityTypesByDateView(
							this.getSelectedData().getProductTypeId(), this.getSearchDate()));
				}
			}
			if (this.getRelatedDataList().isEmpty()) {
				logger.info("No related data to show");

			} else {
				logger.info("Load related data sucessful");
			}
		} else {
			errorMessage = "The selected product type is null";
			logger.error(errorMessage);
			throw new CoMaSwDataAccessException(errorMessage);
		}

	}

	@Override
	public void loadCandidateDataList() {
		String errorMessage;

		if ((this.getSelectedData() != null) && (this.getSelectedData().getProductTypeId() != null)
				&& (this.getSelectedData().getProductTypeId() != 0)) {
			this.setCandidateDataList(
					productPromotionTypeEJB.findEntityTypeCandidates(this.getSelectedData().getProductTypeId()));
			if (this.getCandidateDataList().isEmpty()) {
				logger.info("No candidate data to show");

			} else {
				logger.info("Load candidate data sucessful");
			}
		} else {
			errorMessage = "The selected product type is null";
			logger.error(errorMessage);
			throw new CoMaSwDataAccessException(errorMessage);
		}

	}

	@Override
	public void loadHistoricCandidateDataList() {
		String errorMessage;

		if ((this.getSelectedCandidateData() != null) && (this.getSelectedCandidateData().getPromotionTypeId() != null)
				&& (this.getSelectedCandidateData().getPromotionTypeId() != 0)) {
			this.setHistoricCandidateDataList(
					promotionTypeEJB.findDataByPromotionTypeId(this.getSelectedCandidateData().getPromotionTypeId()));
			if (this.getHistoricCandidateDataList().isEmpty()) {
				logger.info("No candidate data to show");

			} else {
				logger.info("Load historic candidate data sucessful");
			}
		} else {
			errorMessage = "The selected product type is null";
			logger.error(errorMessage);
			throw new CoMaSwDataAccessException(errorMessage);
		}

	}

	@Override
	public void pushShowHistoricCandidateRowButton() {
		String message = "SHOW HISTORIC CANDIDATE DATA";
		String messageDetail = "";
		DataTable dataTable;
		CtPromotionType dataObject;

		dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(CANDIDATE_DATA_TABLE_ID);

		dataObject = (CtPromotionType) dataTable.getRowData();

		if (dataObject == null || dataObject.getPromotionTypeId() == null) {
			messageDetail = "No selected promotion type to shown";
			logger.error(message + " - " + messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
					"The selected promotion type to shown is null");
			facesContext.validationFailed();
		} else {
			// Gets selectedData
			this.setSelectedCandidateData(dataObject);
			this.loadHistoricCandidateDataList();
			this.resetFilterHistoricCandidateDataTable();

			messageDetail = "Shown historic data for the promotion type:" + this.getSelectedCandidateData().getCode();
			logger.info(message + " - " + messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);
		}

	}

	@Override
	public void resetFilterHistoricCandidateDataTable() {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('historicCandidateTableWidget').clearFilters()");

	}

	@Override
	public void pushSearchButton() {
		String message = "SEARCH DATA";
		String messageDetail = "";
		this.loadDataList();
		if (this.getDataList().isEmpty()) {
			messageDetail = "No data to show ";
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

	@Override
	public void pushSelectedButton() {
		String message = "SHOW DATA PRODUCT RELATION";
		String messageDetail = "";
		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(DATA_TABLE_ID);

		// Gets the selected data
		this.setInjectSelectedData((CtProductType) dataTable.getRowData());

		if (this.getInjectSelectedData() == null | this.getInjectSelectedData().getProductTypeId() == null
				|| this.getInjectSelectedData().getProductTypeId() == 0) {
			messageDetail = "The product type is null";
			logger.error(message + " - " + messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);

		} else {
			this.setSelectedData(this.getInjectSelectedData());
			this.loadCandidateDataList();
			this.loadRelatedDataList();
			this.setShowDependentData(true);

			this.resetFilterCandidateDataTable();
			this.resetFilterRelatedDataTable();

			messageDetail = "Shown data for product: ";
			logger.info(message + " - " + messageDetail + this.getSelectedData().toString());
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
					messageDetail + this.getSelectedData().getCode());

			PrimeFaces.current().executeScript("PF('searchListWidget').hide();");
			PrimeFaces.current().executeScript("PF('multipleAccordionPanelWidget').selectAll();");

		}

	}

	@Override
	public void pushAddButtonCandidateToRelatedData() {
		String message = "ADD PROMOTION TYPE TO PRODUCT";
		String messageDetail = "";
		DataTable mainDataTable;
		DataTable otherDataTable;

		if (this.getSelectedData() == null) {

			messageDetail = "The product type is null";
			logger.error(message + " - " + messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);

		} else {

			mainDataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
					.findComponent(CANDIDATE_DATA_TABLE_ID);
			otherDataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
					.findComponent(RELATED_DATA_TABLE_ID);

			if (mainDataTable.getSelection() == null
					|| ((CtPromotionType) mainDataTable.getSelection()).getPromotionTypeId() == null) {
				messageDetail = "No selected promotion type to add for the product type "
						+ this.getSelectedData().toString();
				logger.error(message + " - " + messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
						"The selected promotion type to add is null");
				facesContext.validationFailed();
			} else {
				// Gets selectedData
				this.injectSelectedCandidateData = (CtPromotionType) mainDataTable.getSelection();

				CtPromoProdType dataObject = new CtPromoProdType();
				dataObject.setProductTypeId(this.getSelectedData().getProductTypeId());
				dataObject.setPromotionTypeId(this.getInjectSelectedCandidateData().getPromotionTypeId());
				dataObject.setInputUser(this.loggedUser.getUserCode());
				dataObject.setInputDate(LocalDateTime.now());
				dataObject.setStatusId((Integer) statusEJB.findDataByCode(ACTIVE_STATUS_CODE).getStatusId());
				try {
					productPromotionTypeEJB.insertData(dataObject);
					this.loadCandidateDataList();
					this.loadRelatedDataList();

					// Unselect selected rows
					mainDataTable.setRowIndex(-1);
					otherDataTable.setRowIndex(-1);

					this.resetFilterCandidateDataTable();
					this.resetFilterRelatedDataTable();

					messageDetail = "The product promotion type relation was added";
					logger.info(message + " - " + messageDetail + dataObject.toString());
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);

				} catch (CoMaSwDataAccessException e) {
					messageDetail = "Error while adding the selected product promotion type relation ";
					logger.error(message + " - " + messageDetail + dataObject.toString());
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
							messageDetail);
					facesContext.validationFailed();
				}

				this.injectSelectedCandidateData = null;

			}
		}

	}

	@Override
	public void pushRemoveButtonFromRelatedData() {
		String message = "REMOVE PROMOTION TYPE FROM PRODUCT";
		String messageDetail = "";
		DataTable mainDataTable;
		DataTable otherDataTable;

		if (this.getSelectedData() == null) {

			messageDetail = "The product type is null";
			logger.error(message + " - " + messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);

		} else {

			mainDataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
					.findComponent(RELATED_DATA_TABLE_ID);

			otherDataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
					.findComponent(CANDIDATE_DATA_TABLE_ID);

			if (mainDataTable.getSelection() == null
					|| ((VwPromotionProductType) mainDataTable.getSelection()).getPromoProdTypeId() == null) {
				messageDetail = "No selected promotion type to remove for the selected product type ";
				logger.error(message + " - " + messageDetail + this.getSelectedData().toString());
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				facesContext.validationFailed();
			} else {
				// Gets selectedData
				this.setInjectSelectedRelatedData((VwPromotionProductType) mainDataTable.getSelection());

				CtPromoProdType dataObject = productPromotionTypeEJB
						.findEntityRelationType(this.injectSelectedRelatedData.getPromoProdTypeId());
				try {
					productPromotionTypeEJB.deleteData(dataObject);
					this.loadCandidateDataList();
					this.loadRelatedDataList();

					// Unselect selected rows
					mainDataTable.setRowIndex(-1);
					otherDataTable.setRowIndex(-1);

					this.resetFilterCandidateDataTable();
					this.resetFilterRelatedDataTable();

					messageDetail = "The selected product promotion type relation was removed";
					logger.info(message + " - " + messageDetail + dataObject.toString());
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							"The selected promotion type was removed");

				} catch (CoMaSwDataAccessException e) {
					messageDetail = "Error while removing the selected product promotion type relation ";
					logger.error(message + " - " + messageDetail + dataObject.toString());
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
							messageDetail);
					facesContext.validationFailed();
				}

				this.injectSelectedRelatedData = null;
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
	public void resetFilterCandidateDataTable() {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('candidateTableWidget').clearFilters()");
	}

	@Override
	public void refreshCandidateDataTable() {
		if (this.isShowDependentData()) {
			if (this.getSelectedData() == null) {
				// recover the selected data from the selected table
				if (this.getSelectedDataList().get(0) != null) {
					this.setSelectedData(this.getSelectedDataList().get(0));
				}
			}
			this.resetFilterCandidateDataTable();
			this.loadCandidateDataList();
			Ajax.update(CANDIDATE_DATA_TABLE_ID);
		}
	}

	@Override
	public void resetFilterRelatedDataTable() {
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('relatedTableWidget').clearFilters()");
	}

	@Override
	public void refreshRelatedDataTable() {
		if (this.isShowDependentData()) {
			if (this.getSelectedData() == null) {
				// recover the selected data from the selected table
				if (this.getSelectedDataList().get(0) != null) {
					this.setSelectedData(this.getSelectedDataList().get(0));
				}
			}
			this.resetFilterRelatedDataTable();
			this.loadRelatedDataList();
			Ajax.update(RELATED_DATA_TABLE_ID);
		}
	}

	@Override
	public void onRelatedRowInit(RowEditEvent<?> event) {
		String message, messageDetail;
		VwPromotionProductType dataObjectView;
		CtPromoProdType dataObject;

		message = "EDIT ROW";

		// Retrieved the data that was modified
		dataObjectView = (VwPromotionProductType) event.getObject();
		dataObject = productPromotionTypeEJB.findEntityRelationType(dataObjectView.getPromoProdTypeId());

		this.setSelectedRelatedData(dataObjectView);

		messageDetail = "Editing product_promotion_type: ";
		logger.info(messageDetail + dataObject.toString());
		this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
				messageDetail + " for product: " + dataObjectView.getProductTypeCode() + " and promotion: "
						+ dataObjectView.getPromotionTypeCode());

	}

	@Override
	public void onRelatedRowEdit(RowEditEvent<?> event) throws ValidatorException {
		String message, messageDetail;
		VwPromotionProductType dataObjectView;
		CtPromoProdType dataObject;
		boolean error = false;

		message = "SAVE EDIT ROW";

		// Retrieved the data that was modified
		dataObjectView = (VwPromotionProductType) event.getObject();
		dataObject = productPromotionTypeEJB.findEntityRelationType(dataObjectView.getPromoProdTypeId());
		dataObject.setStatusId(dataObjectView.getPromoProdTypeStatusId());
		dataObject.setModifDate(LocalDateTime.now());
		dataObject.setModifUser(this.getLoggedUser().getUserCode());

		try {

			productPromotionTypeEJB.updateData(dataObject);
			messageDetail = "Data saves correctly";
			logger.info("Update the status of the product_promotion_type_id  " + dataObject.toString() + " - "
					+ messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);

		} catch (EJBException e) {
			error = true;
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwDataAccessException")) {
				messageDetail = "DATA ACCES ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			} else if (ne.getClass().getName().equals("es.comasw.exception.CoMaSwParseException")) {
				messageDetail = "PARSE ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			} else {
				messageDetail = "ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}

		} catch (Exception e) {
			messageDetail = "ERROR - " + e.getMessage();
			logger.fatal(messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
		} finally {
			if (error) {
				facesContext.validationFailed();
			} else {
				this.refreshRelatedDataTable();
				this.loadRelatedDataList();
			}
		}

	}

	@Override
	public void onRelatedRowCancel(RowEditEvent<?> event) {
		String message, messageDetail;
		VwPromotionProductType dataObjectView;
		message = "CANCEL UPDATE ROW";
		messageDetail = "Cancelled the edition for the product_promotion_type ";

		dataObjectView = (VwPromotionProductType) event.getObject();

		logger.info(messageDetail + "product_type: " + dataObjectView.getProductTypeCode() + " - promotion_type: "
				+ dataObjectView.getPromotionTypeCode());
		this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
				messageDetail + dataObjectView.toString());

	}

	@Override
	public void setInitVariablesToDefault() {
		this.setShowDependentData(false);
		this.setHistoricRelatedDataCriteria(false);
	}

	@Override
	public void setControlVariablesToDefault() {
		this.setInitVariablesToDefault();

	}
	

	@Override
	public void changeSearchDataTableTitle() {
		// TODO Auto-generated method stub
		
	}
}
