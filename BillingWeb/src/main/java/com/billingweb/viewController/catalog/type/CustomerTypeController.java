/**
 * 
 */
package com.billingweb.viewController.catalog.type;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

import com.billingweb.ejb.catalog.type.CustomerTypeEJBLocal;
import com.billingweb.generalClass.SimpleTableBasicClassWithLists;
import com.billingweb.interfaces.IGeneralController;
import com.billingweb.model.tables.pojos.CtBillCycleType;
import com.billingweb.model.tables.pojos.CtCustomerType;
import com.billingweb.model.tables.pojos.VwUsers;

@Named
@ViewScoped
/**
 * @author catuxa
 *
 */
public class CustomerTypeController extends SimpleTableBasicClassWithLists implements Serializable, IGeneralController {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5290300673257578571L;

	Logger logger = (Logger) LogManager.getLogger(CustomerTypeController.class);

	String DATA_TABLE_ID = "form:" + CustomerTypeController.uiValues.getString("dataTableID");
	String NEW_PANEL_DATA_ID = "form:" + CustomerTypeController.uiValues.getString("newPanelDataID");
	
	private static final Integer ENTITY_TYPE_ID = Integer
			.valueOf(dbDefinitions.getString("ENTITY_TYPE_ID_CUST"));
	
	

	@Inject
	private ExternalContext externalContext;
	@Inject
	private FacesContext facesContext;

	@EJB
	private CustomerTypeEJBLocal customerTypeEJB;
	
	
	/**
	 * Entity data list
	 */
	private List<CtCustomerType> dataList;

	/**
	 * Application level filtered data list
	 */
	private List<CtCustomerType> filteredDataList;

	/**
	 * Selected data row in the table
	 */
	@Inject
	private CtCustomerType selectedData;

	/**
	 * Backup object for entity type(delete/modify operations)
	 */
	private CtCustomerType backupData;
	
	
	private VwUsers loginUser;
	

	// --------------------
	// GETTERS AND SETTERS
	// -------------------

	
	/**
	 * @return the dataList
	 */
	public List<CtCustomerType> getDataList() {
		return dataList;
	}


	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(List<CtCustomerType> dataList) {
		this.dataList = dataList;
	}


	/**
	 * @return the filteredDataList
	 */
	public List<CtCustomerType> getFilteredDataList() {
		return filteredDataList;
	}


	/**
	 * @param filteredDataList the filteredDataList to set
	 */
	public void setFilteredDataList(List<CtCustomerType> filteredDataList) {
		this.filteredDataList = filteredDataList;
	}


	/**
	 * @return the selectedData
	 */
	public CtCustomerType getSelectedData() {
		return selectedData;
	}


	/**
	 * @param selectedData the selectedData to set
	 */
	public void setSelectedData(CtCustomerType selectedData) {
		this.selectedData = selectedData;
	}


	/**
	 * @return the backupData
	 */
	public CtCustomerType getBackupData() {
		return backupData;
	}


	/**
	 * @param backupData the backupData to set
	 */
	public void setBackupData(CtCustomerType backupData) {
		this.backupData = backupData;
	}


	/**
	 * @return the loginUser
	 */
	public VwUsers getLoginUser() {
		return loginUser;
	}


	/**
	 * @param loginUser the loginUser to set
	 */
	public void setLoginUser(VwUsers loginUser) {
		this.loginUser = loginUser;
	}
	
	
	// -------------------
	// METHODS
	// -------------------
	
	
	
	/**
	 * 
	 */
	public CustomerTypeController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@PostConstruct
	public void init() {

		if (selectedData == null) {
			selectedData = new CtCustomerType();
		}

		if (this.backupData == null) {
			this.backupData = new CtCustomerType();
		}
		
		if (this.loginUser == null) {
			this.loginUser = (VwUsers) externalContext.getSessionMap().get("applicationUser");
		}

	}

	@Override
	public void loadDataList() {
		dataList = customerTypeEJB.findAllData();
		if (dataList.isEmpty()) {
			logger.info("No data to show");

		} else {
			logger.info("Load data sucessful");
		}
		
		
	}



	@Override
	public void onRowInit(RowEditEvent<?> event) {
		String message, messageDetail;

		CtCustomerType dataObject;

		message = "EDIT ROW";

		DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(DATA_TABLE_ID);
		int rowPosition = dataTable.getRowIndex();

		// Gets the backup of the data to modify
		dataObject = (CtCustomerType) event.getObject();
		this.backupData.from(dataObject);

		// If we are editing a row, we must disabled all the other buttons
		this.editingMode = true;

		// Due to the update of the entire table to show the password column
		// the edition of the row set to unselect --> force to expand the edit button
		PrimeFaces.current().executeScript(
				"jQuery('span.ui-icon-pencil').eq(" + rowPosition + ").each(function(){jQuery(this).click()});");

		// If we are modifing a row we can't add a new row --> Disable all the other
		// buttons

		messageDetail = "Editing customer type: " + dataObject.getCode();
		logger.info(messageDetail);
		this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);
		
		
	}


	@Override
	public void onRowEdit(RowEditEvent<?> event) throws ValidatorException {
		CtCustomerType dataObject;
		String message, messageDetail;
		boolean error = false;

		message = "SAVE EDIT ROW";

		// Retrieved the data that was modified
		dataObject = (CtCustomerType) event.getObject();

				
		try {

			// Validates the data
			if (this.objectValidation(dataObject)) {
				//sets the modif data
				this.selectedData.setModifUser(this.loginUser.getUserCode());
				this.selectedData.setModifDate(LocalDateTime.now());
				
				customerTypeEJB.updateData(dataObject);
				messageDetail = "Data saves correctly";
				logger.info("Update customer type: " + this.selectedData.toString() + " - " +messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);
				this.setControlVariablesToDefault();
			} else {
				messageDetail = "ERROR - Data values are incorrect";
				error = true;
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, message, messageDetail));
			}
		} catch (EJBException e) {
			error = true;
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.billingweb.exception.BillingWebDataAccessException")) {
				messageDetail = "DATA ACCES ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			} else if (ne.getClass().getName().equals("es.billingweb.exception.BillingWebParseException")) {
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
				FacesContext.getCurrentInstance().validationFailed();
			} else {				
				this.loadDataList();
			}
		}
		
	}


	@Override
	public void onRowCancel(RowEditEvent<?> event) {
		CtCustomerType dataObject;
		String message, messageDetail;

		message = "CANCEL UPDATE ROW";

		dataObject = (CtCustomerType) event.getObject();
		dataObject.from(this.backupData);

		messageDetail = "Cancelled the edition of the customer type";
		logger.info(messageDetail);
		this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);

		this.setControlVariablesToDefault();
		
	}


	@Override
	public void pushAddNewRowButton() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pushDeleteRowButton() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pushUpdateRowButton() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pushAddNewButton() {
		this.selectedData = new CtCustomerType();
		PrimeFaces.current().executeScript("PF('createNewDialogWidget').show();");
		
	}


	@Override
	public void pushConfirmButtonAddNewDialog() {
		String message = "INSERT NEW DATA";
		String messageDetail = "";
		Boolean error = false;

		try {
			if (objectValidation(this.selectedData)) {
				//Set create values
				
				this.selectedData.setEntityTypeId(ENTITY_TYPE_ID);
				this.selectedData.setInputUser(this.loginUser.getUserCode());
				this.selectedData.setInputDate(LocalDateTime.now());
				
				customerTypeEJB.insertData(this.selectedData);
				messageDetail = "Data saves succesfully";
				logger.info("Create customer type: " + this.selectedData.toString() + " - " +messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);

			} else {
				error = true;
			}
		} catch (EJBException e) {
			error = true;
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.billingweb.exception.BillingWebDataAccessException")) {
				messageDetail = "DATA ACCES ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			} else if (ne.getClass().getName().equals("es.billingweb.exception.BillingWebParseException")) {
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
				this.loadDataList();
				PrimeFaces.current().executeScript("PF('createNewDialogWidget').hide();"); 
			}
		}
		
	}


	@Override
	public void pushCancelButtonAddNewDialog() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pushCleanButtonAddNewDialog() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pushConfirmButtonDeleteDialog() {
		String message = "DELETE ROW";
		String messageDetail = "";
		Boolean error = false;

		try {
			if (this.selectedData != null) {
				customerTypeEJB.deleteData(this.selectedData);
				messageDetail = "Data deletes succesfully";
				logger.info("Delete customer type: " + this.selectedData.toString() + " - " + messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);
			} else {
				error = true;
				messageDetail = "ERROR - Selected data is null";
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			}
		} catch (EJBException e) {
			error = true;
			Exception ne = (Exception) e.getCause();
			if (ne.getClass().getName().equals("es.billingweb.exception.BillingWebDataAccessException")) {
				messageDetail = "DATA ACCES ERROR - " + ne.getMessage();
				logger.fatal(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_FATAL, message, messageDetail);

			} else if (ne.getClass().getName().equals("es.billingweb.exception.BillingWebParseException")) {
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
				this.loadDataList();
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
		boolean result = true;
		CtCustomerType objectToValidate;
		String message = "DATA VALIDATION";
		String messageDetail = "";

		objectToValidate = (CtCustomerType) dataObject;

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
			
			if (objectToValidate.getCode() == null || objectToValidate.getCode().length() == 0) {
				messageDetail = "ERROR - The code of the customer type can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				result = false;
			} else if (((Integer) objectToValidate.getCode().length())
					.compareTo(BillCycleTypeController.CODE_FIELD_LENGTH_MAX) > 0) {
				// length characters exceeds the maximum length
				messageDetail = "Error - The code of the customer type (" + objectToValidate.getCode().length()
						+ " characters) exceeds the limit of "
						+ BillCycleTypeController.CODE_FIELD_LENGTH_MAX.toString() + " characters";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				result = false;
			}
			if (objectToValidate.getName() == null || objectToValidate.getName().length() == 0) {
				messageDetail = "ERROR - The name of the customer type can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				result = false;
			} else if (((Integer) objectToValidate.getName().length())
					.compareTo(BillCycleTypeController.NAME_FIELD_LENGTH_MAX) > 0) {
				// length characters exceeds the maximum length
				messageDetail = "Error - The name of the customer type (" + objectToValidate.getName().length()
						+ " characters) exceeds the limit of "
						+ BillCycleTypeController.NAME_FIELD_LENGTH_MAX.toString() + " characters";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				result = false;
			}

			if (objectToValidate.getDescription() == null || objectToValidate.getDescription().length() == 0) {
				messageDetail = "ERROR - The description of the customer type can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				result = false;
			} else if (((Integer) objectToValidate.getDescription().length())
					.compareTo(BillCycleTypeController.DESCRIPTION_FIELD_LENGTH_MAX) > 0) {
				// length characters exceeds the maximum length
				messageDetail = "Error - The description of the customer type ("
						+ objectToValidate.getDescription().length()
						+ " characters) exceeds the limit of "
						+ BillCycleTypeController.DESCRIPTION_FIELD_LENGTH_MAX.toString() + " characters";

				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
				result = false;
			}
			
			
			if (objectToValidate.getStatusId() == null) {
				result = false;
				messageDetail = "ERROR - The status can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}
			

			if (result) {
				// no error --> update panel
				Ajax.update(NEW_PANEL_DATA_ID);
			}

		} else {
			messageDetail = "ERROR - Empty values";
			logger.error(messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			result = false;
		}
		return result;
	}


	@Override
	public void retrieveBackupData() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setInitVariablesToDefault() {
		this.editingMode = false;
		
	}


	@Override
	public void setControlVariablesToDefault() {
		this.setInitVariablesToDefault();
		
	}

	

}