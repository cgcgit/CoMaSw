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

package com.comasw.generalClass;

import java.util.List;

public class BasicRelationType<T, S, U> extends BasicTypeWithLists<T> {

	protected String DATA_TABLE_ID = "form:accordionPanel:" + uiValues.getString("dataTableID");

	protected String RELATED_DATA_TABLE_ID = "form:accordionPanel:" + uiValues.getString("relatedDataTableID");

	protected String CANDIDATE_DATA_TABLE_ID = "form:accordionPanel:" + uiValues.getString("candidateDataTableID");

	/**
	 * Indicates if the data form must be shown
	 */
	protected boolean showDependentData = false;

	/**
	 * Related data list
	 */
	protected List<S> relatedDataList;

	/**
	 * Filtered data list for related data
	 */
	protected List<S> filteredRelatedDataList;

	/**
	 * Candidate data list
	 */
	protected List<U> candidateDataList;

	/**
	 * Filtered data list for candidate data
	 */
	protected List<U> filteredCandidateDataList;

	/**
	 * Selected related data
	 */
	protected S selectedRelatedData;

	/**
	 * Selected candidate data
	 */
	protected U selectedCandidateData;
	
	
	// --------------------
	// GETTERS AND SETTERS
	// -------------------

	/**
	 * @return the relatedDataList
	 */
	public List<S> getRelatedDataList() {
		return relatedDataList;
	}

	/**
	 * @param relatedDataList the relatedDataList to set
	 */
	public void setRelatedDataList(List<S> relatedDataList) {
		this.relatedDataList = relatedDataList;
	}

	/**
	 * @return the filteredRelatedDataList
	 */
	public List<S> getFilteredRelatedDataList() {
		return filteredRelatedDataList;
	}

	/**
	 * @param filteredRelatedDataList the filteredRelatedDataList to set
	 */
	public void setFilteredRelatedDataList(List<S> filteredRelatedDataList) {
		this.filteredRelatedDataList = filteredRelatedDataList;
	}

	/**
	 * @return the candidateDataList
	 */
	public List<U> getCandidateDataList() {
		return candidateDataList;
	}

	/**
	 * @param candidateDataList the candidateDataList to set
	 */
	public void setCandidateDataList(List<U> candidateDataList) {
		this.candidateDataList = candidateDataList;
	}

	/**
	 * @return the filteredCandidateDataList
	 */
	public List<U> getFilteredCandidateDataList() {
		return filteredCandidateDataList;
	}

	/**
	 * @param filteredCandidateDataList the filteredCandidateDataList to set
	 */
	public void setFilteredCandidateDataList(List<U> filteredCandidateDataList) {
		this.filteredCandidateDataList = filteredCandidateDataList;
	}

	/**
	 * @return the showDependentData
	 */
	public boolean isShowDependentData() {
		return showDependentData;
	}

	/**
	 * @param showDependentData the showDependentData to set
	 */
	public void setShowDependentData(boolean showDependentData) {
		this.showDependentData = showDependentData;
	}

	/**
	 * @return the selectedRelatedData
	 */
	public S getSelectedRelatedData() {
		return selectedRelatedData;
	}

	/**
	 * @param selectedRelatedData the selectedRelatedDataList to set
	 */
	public void setSelectedRelatedData(S selectedRelatedData) {
		this.selectedRelatedData = selectedRelatedData;
	}

	/**
	 * @return the selectedCandidateData
	 */
	public U getSelectedCandidateData() {
		return selectedCandidateData;
	}

	/**
	 * @param selectedCandidateData the selectedCandidateData to set
	 */
	public void setSelectedCandidateData(U selectedCandidateData) {
		this.selectedCandidateData = selectedCandidateData;
	}

}
