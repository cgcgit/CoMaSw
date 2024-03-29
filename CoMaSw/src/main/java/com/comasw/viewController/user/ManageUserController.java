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

package com.comasw.viewController.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.primefaces.PrimeFaces;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;

import com.comasw.model.tables.pojos.ItProfiles;
import com.comasw.model.tables.pojos.ItUsers;
import com.comasw.ejb.user.ApplicationUserEJBLocal;
import com.comasw.ejb.user.ProfileEJBLocal;
import com.comasw.generalClass.BasicType;
import com.comasw.interfaces.IEditableTable;
import com.comasw.utilities.Utilities;

@Named
@ViewScoped
public class ManageUserController extends BasicType<ItUsers> implements Serializable, IEditableTable {

	private static final long serialVersionUID = -1912863991314774382L;

	private static final Integer MAX_LENGTH_USER_CODE = Integer
			.valueOf(dbDefinitions.getString("CODE_FIELD_LENGTH_MAX"));
	private static final Integer MAX_LENGTH_NAME = Integer
			.valueOf(dbDefinitions.getString("USER_NAME_FIELD_LENGTH_MAX"));
	private static final Integer MAX_LENGTH_SURNAME = Integer
			.valueOf(dbDefinitions.getString("USER_SURNAME_FIELD_LENGTH_MAX"));
	private static final Integer MAX_LENGTH_EMAIL = Integer
			.valueOf(dbDefinitions.getString("USER_EMAIL_FIELD_LENGTH_MAX"));
	private static final Integer MAX_LENGTH_PHONE_CONTACT = Integer
			.valueOf(dbDefinitions.getString("USER_PHONE_CONTACT_FIELD_LENGTH_MAX"));
	private static final Integer MIN_LENGTH_PASSWORD = Integer
			.valueOf(dbDefinitions.getString("USER_PASSWORD_FIELD_LENGTH_MIN"));
	private static final Integer MAX_LENGTH_PASSWORD = Integer
			.valueOf(dbDefinitions.getString("USER_PASSWORD_FIELD_LENGTH_MAX"));

	Logger logger = (Logger) LogManager.getLogger(ManageUserController.class);

	String GROWL_MESSAGE_ID = "form:" + BasicType.uiValues.getString("growlMessageID");
	String DATA_TABLE_ID = "form:" + BasicType.uiValues.getString("dataTableID");
	String NEW_PANEL_DATA_ID = "form:" + BasicType.uiValues.getString("newPanelDataID");

	@Inject
	private ExternalContext externalContext;
	@Inject
	private FacesContext facesContext;

	@EJB
	private ProfileEJBLocal profileEJB;

	@EJB
	private ApplicationUserEJBLocal applicationUserEJB;

	
	private ItUsers selectedData;
	
	private ItUsers newData;

	private List<SelectItem> profileList;

	private List<ItUsers> dataList;

	private ItUsers backupData;

	private String password;

	// ---------------------
	// GETTERS AND SETTERS
	// ---------------------

	/**
	 * @return the selectedData
	 */
	public ItUsers getSelectedData() {
		return selectedData;
	}

	/**
	 * @param selectedData the selectedData to set
	 */
	public void setSelectedData(ItUsers selectedData) {
		this.selectedData = selectedData;
	}

	
	/**
	 * @return the newData
	 */
	public ItUsers getNewData() {
		return newData;
	}

	/**
	 * @param newData the newData to set
	 */
	public void setNewData(ItUsers newData) {
		this.newData = newData;
	}
	
	/**
	 * @return the profileList
	 */
	public List<SelectItem> getProfileList() {
		return profileList;
	}

	/**
	 * @param profileList the profileList to set
	 */
	public void setProfileList(List<SelectItem> profileList) {
		this.profileList = profileList;
	}

	/**
	 * @return the dataList
	 */
	public List<ItUsers> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(List<ItUsers> dataList) {
		this.dataList = dataList;
	}

	/**
	 * @return the backupData
	 */
	public ItUsers getBackupData() {
		return backupData;
	}

	/**
	 * @param backupData the backupData to set
	 */
	public void setBackupData(ItUsers backupData) {
		this.backupData = backupData;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	// ---------------------
	// METHODS
	// ---------------------

	public ManageUserController() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
	
		if (this.getSelectedData() == null) {
			this.setSelectedData (new ItUsers());
		}
		
		if (this.getNewData() == null) {
			this.setNewData(new ItUsers());
		}

		if (this.getBackupData() == null) {
			this.setBackupData (new ItUsers());
		}
		
		if (this.getProfileList() == null) {
			this.setProfileList(new ArrayList<>());
		}
			
		if (this.getDataList() == null ) {
			this.setDataList(new  ArrayList<ItUsers> ());
		}
		
		if (this.getBackupData() == null){
			this.setBackupData(new ItUsers());
		}

	}

	@Override
	public void loadDataList() {
		dataList = applicationUserEJB.findData();
		if (dataList.isEmpty()) {
			logger.info("No data to show");

		} else {
			logger.info("Load data sucessful");
		}

	}

	@Override
	public void onRowInit(RowEditEvent<?> event) {
		String message, messageDetail;

		ItUsers dataObject;

		message = "EDIT ROW";

		DataTable dataTable = (DataTable) facesContext.getViewRoot().findComponent(DATA_TABLE_ID);
		int rowPosition = dataTable.getRowIndex();

		this.password = null;

		// Gets the backup of the data to modify
		dataObject = (ItUsers) event.getObject();
		this.backupData.from(dataObject);

		this.editingMode = true;

		// Due to the update of the entire table to show the password column
		// the edition of the row set to unselect --> force to expand the edit button
		PrimeFaces.current().executeScript(
				"jQuery('span.ui-icon-pencil').eq(" + rowPosition + ").each(function(){jQuery(this).click()});");

		messageDetail = "Editing user: " + dataObject.getUserCode();
		logger.info(messageDetail);
		this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);

	}

	@Override
	public void onRowEdit(RowEditEvent<?> event) throws ValidatorException {
		ItUsers dataObject;
		String message, messageDetail;
		boolean error = false;

		boolean validation = true;

		message = "SAVE EDIT ROW";

		// Retrieved the data that was modified
		dataObject = (ItUsers) event.getObject();

		try {
			// Validates the password
			if ((this.password == null) || (this.password.length() == 0)) {
				// The password was not updated
			} else if ((((Integer) this.password.length()).compareTo(MIN_LENGTH_PASSWORD) < 0)
					|| (((Integer) this.password.length()).compareTo(MAX_LENGTH_PASSWORD) > 0)) {

				// length characters exceeds the maximum length
				validation = false;
				messageDetail = "Error - The password (" + password.length() + " characters) must be between "
						+ MIN_LENGTH_PASSWORD.toString() + " and " + MAX_LENGTH_PASSWORD.toString() + " characters";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);

			} else {
				// password is OK --> md5 to the password
				validation = true;
				dataObject.setPassword(Utilities.MD5(this.password));

			}

			if (this.objectValidation(dataObject)) {

				if (validation) {
					applicationUserEJB.updateData(dataObject);
					messageDetail = "Data saves correctly";
					logger.info("Update user: " + this.selectedData.getUserCode() + " - " + messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);
					this.setControlVariablesToDefault();
				} else {
					error = true;
					messageDetail = "ERROR - Data values are incorrect";
					throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, message, messageDetail));

				}
			} else {
				error = true;
				messageDetail = "ERROR - Data values are incorrect";
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_FATAL, message, messageDetail));
			}
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
				FacesContext.getCurrentInstance().validationFailed();
				// Ajax.update(GROWL_MESSAGE_ID);
			} else {
				this.loadDataList();
			}
		}

	}

	@Override
	public void onRowCancel(RowEditEvent<?> event) {
		ItUsers dataObject;
		String message, messageDetail;

		message = "CANCEL UPDATE ROW";

		dataObject = (ItUsers) event.getObject();
		dataObject.from(this.backupData);

		messageDetail = "Cancelled the edition of the application level";
		logger.info(messageDetail);
		this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message, messageDetail);

		this.setControlVariablesToDefault();
	}

	@Override
	public void pushDeleteRowButton() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pushCreateNewButton() {
		this.setNewData(new ItUsers());
		PrimeFaces.current().executeScript("PF('createNewDialogWidget').show();");

	}

	@Override
	public void pushConfirmButtonCreateNewDialog() {
		String message = "INSERT NEW DATA";
		String messageDetail = "";
		boolean error = false;
		boolean validation = true;

		try {
			
			if (this.getNewData() == null) {
				validation = false;
				messageDetail = "Error - Please fill the fields to create a new user.";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, "DATA VALIDATION",
						messageDetail);
				
			} else if ((this.getNewData().getPassword() == null )|| (this.getNewData().getPassword().length() == 0)) {
				validation = false;
				messageDetail = "Error - The password can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, "DATA VALIDATION",
						messageDetail);				

			} else if ((((Integer) this.getNewData().getPassword().length()).compareTo(MIN_LENGTH_PASSWORD) < 0)
					|| (((Integer) this.getNewData().getPassword().length()).compareTo(MAX_LENGTH_PASSWORD) > 0)) {
				// length characters exceeds the maximum length
				validation = false;
				messageDetail = "Error - The password (" + this.getNewData().getPassword().length() + " characters) must be between "
						+ MIN_LENGTH_PASSWORD.toString() + "and " + MAX_LENGTH_PASSWORD.toString() + " characters";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, "DATA VALIDATION",
						messageDetail);

			} else {
				// password is OK --> md5 password
				validation = true;
				this.getNewData().setPassword(Utilities.MD5(this.getNewData().getPassword()));
			}

			if (objectValidation(this.getNewData())) {
				if (validation) {
					applicationUserEJB.insertData(this.getNewData());
					messageDetail = "Data saved succesfully";
					logger.info("Create user: " + this.getNewData().getUserCode() + " - " + messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_INFO, message,
							messageDetail);

				} else {
					error = true;
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
				this.loadDataList();
				// Ajax.update(DATA_TABLE_ID);
				PrimeFaces.current().executeScript("PF('createNewDialogWidget').hide();");
				// PrimeFaces.current().ajax().update("form:mainTable");
			}
		}

	}

	@Override
	public void pushCancelButtonCreateNewDialog() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pushCleanButtonCreateNewDialog() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pushConfirmButtonDeleteDialog() {
		String message = "DELETE ROW";
		String messageDetail = "";
		Boolean error = false;

		try {
			if (this.selectedData != null) {
				applicationUserEJB.deleteData(this.selectedData);
				// this.selectedData = null;
				messageDetail = "Data deleted succesfully";
				logger.info("Delete user: " + this.selectedData.getUserCode() + " - " + messageDetail);
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
		// Note: the password will be validated out of this method,
		// due to if the validation is for an update maybe the password
		// not need to be updated

		boolean result = true;
		ItUsers objectToValidate;
		String message = "DATA VALIDATION";
		String messageDetail = "";

		objectToValidate = (ItUsers) dataObject;

		if (objectToValidate != null) {

			// required file validation was defined in the view

			if (objectToValidate.getName() != null) {
				objectToValidate.setName(objectToValidate.getName().trim());
			}

			if (objectToValidate.getSurname() != null) {
				objectToValidate.setSurname(objectToValidate.getSurname().trim());
			}

			if (objectToValidate.getEmail() != null) {
				objectToValidate.setEmail(objectToValidate.getEmail().trim());
			}

			if (objectToValidate.getUserCode() != null) {
				objectToValidate.setUserCode(objectToValidate.getUserCode().toUpperCase().trim());
			}

			if (objectToValidate.getName() == null || objectToValidate.getName().length() == 0) {
				result = false;
				messageDetail = "ERROR - The user name can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			} else if (((Integer) objectToValidate.getName().length()).compareTo(MAX_LENGTH_NAME) > 0) {
				// length characters exceeds the maximum length
				result = false;
				messageDetail = "Error - The user name (" + objectToValidate.getName().length()
						+ " characters) exceeds the limit of " + MAX_LENGTH_NAME.toString() + " characters";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}

			if (objectToValidate.getSurname() == null || objectToValidate.getSurname().length() == 0) {
				result = false;
				messageDetail = "ERROR - The user surname can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			} else if ((((Integer) objectToValidate.getSurname().length()).compareTo(MAX_LENGTH_SURNAME) > 0)) {
				// length characters exceeds the maximum length
				result = false;
				messageDetail = "Error - The user surname (" + objectToValidate.getSurname().length()
						+ " characters) exceeds the limit of " + MAX_LENGTH_SURNAME.toString() + " characters";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}

			if (objectToValidate.getEmail() == null || objectToValidate.getEmail().length() == 0) {
				result = false;
				messageDetail = "ERROR - The email can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			} else if (((Integer) objectToValidate.getEmail().length()).compareTo(MAX_LENGTH_EMAIL) > 0) {
				// length characters exceeds the maximum length
				result = false;
				messageDetail = "Error - The email (" + objectToValidate.getEmail().length()
						+ " characters) exceeds the limit of " + MAX_LENGTH_EMAIL.toString() + " characters";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			} else {
				if (!Utilities.emailValidation(objectToValidate.getEmail())) {
					result = false;
					messageDetail = "Error in the email validation format";
					logger.error(messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
							messageDetail);

				}
			}

			if (objectToValidate.getUserCode() == null || objectToValidate.getUserCode().length() == 0) {
				result = false;
				messageDetail = "ERROR - The user code can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			} else if (((Integer) objectToValidate.getUserCode().length()).compareTo(MAX_LENGTH_USER_CODE) > 0) {
				// length characters exceeds the maximum length
				result = false;
				messageDetail = "Error - The user code (" + objectToValidate.getUserCode().length()
						+ " characters) exceeds the limit of " + MAX_LENGTH_USER_CODE.toString() + " characters";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}

			if (objectToValidate.getPhoneContact() != null) {

				if (((Integer) objectToValidate.getPhoneContact().length()).compareTo(MAX_LENGTH_PHONE_CONTACT) > 0) {
					// length characters exceeds the maximum length
					result = false;
					messageDetail = "Error - The phone contact (" + objectToValidate.getPhoneContact().length()
							+ " characters) exceeds the limit of " + MAX_LENGTH_PHONE_CONTACT.toString()
							+ " characters";
					logger.error(messageDetail);
					this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
							messageDetail);
				} else {
					if (!Utilities.phoneNumberValidation((objectToValidate.getPhoneContact()))) {
						result = false;
						messageDetail = "Error in the phone validation format";
						logger.error(messageDetail);
						this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message,
								messageDetail);
					}
				}
			}

			if (objectToValidate.getProfileId() == null) {
				result = false;
				messageDetail = "ERROR - The profile can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}

			if (objectToValidate.getActive() == null) {
				result = false;
				messageDetail = "ERROR - The active flag can not be null";
				logger.error(messageDetail);
				this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
			}

		} else {
			result = false;
			messageDetail = "ERROR - Empty values";
			logger.error(messageDetail);
			this.createMessage(facesContext, externalContext, FacesMessage.SEVERITY_ERROR, message, messageDetail);
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
		setInitVariablesToDefault();
	}

	public List<SelectItem> populateProfileMenu() {
		List<SelectItem> selectItem = new ArrayList<>();
		List<ItProfiles> list = profileEJB.findData();

		SelectItem nullItem = new SelectItem();
		nullItem.setLabel("Select One... ");
		nullItem.setValue(null);
		selectItem.add(nullItem);

		if (list.isEmpty()) {
			logger.error("ERROR - Not find profile list");
		} else {
			for (ItProfiles p : list) {
				SelectItem item = new SelectItem();
				item.setLabel(p.getProfileCode());
				item.setValue(p.getProfileId());
				selectItem.add(item);
			}
		}
		return selectItem;
	}

	public List<SelectItem> populateBooleanMenu() {
		List<SelectItem> selectItem = new ArrayList<>();

		SelectItem nullItem = new SelectItem();
		nullItem.setLabel("Select One... ");
		nullItem.setValue(null);
		selectItem.add(nullItem);

		SelectItem trueItem = new SelectItem();
		trueItem.setLabel("True");
		trueItem.setValue(true);
		selectItem.add(trueItem);

		SelectItem falseItem = new SelectItem();
		falseItem.setLabel("False");
		falseItem.setValue(false);
		selectItem.add(falseItem);

		return selectItem;
	}

	@Override
	public void resetFilterDataTable() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refreshDataTable() {
		// TODO Auto-generated method stub

	}

}
