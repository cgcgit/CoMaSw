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

package com.comasw.ejb.catalog.type;

import static com.comasw.model.Tables.CT_CUSTOMER_TYPE;
import static org.jooq.impl.DSL.val;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import com.comasw.model.tables.daos.CtCustomerTypeDao;
import com.comasw.model.tables.pojos.CtCustomerType;
import com.comasw.exception.CoMaSwDataAccessException;

/**
 * Session Bean implementation class customerTypeEJB
 */
@Stateless
public class CustomerTypeEJB implements CustomerTypeEJBLocal {

	Logger logger = (Logger) LogManager.getLogger(CustomerTypeEJB.class);

	@Resource(lookup = "java:jboss/datasources/db_comasw")
	private DataSource ds;

	/**
	 * Default constructor.
	 */
	public CustomerTypeEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CtCustomerType> findAllData() throws CoMaSwDataAccessException {
		DSLContext create = DSL.using(ds, SQLDialect.POSTGRES);
		List<CtCustomerType> result = null;
		String errorMessage;

		try {
			result = create.selectFrom(CT_CUSTOMER_TYPE).orderBy(CT_CUSTOMER_TYPE.CODE).fetch()
					.into(CtCustomerType.class);

		} catch (DataAccessException e) {
			errorMessage = "Error while try to find all the customer types - " + e.getMessage();
			logger.error(errorMessage);
			throw new CoMaSwDataAccessException(errorMessage, e);
		}

		return result;
	}

	@Override
	public CtCustomerType findDataByCustomerTypeId(Integer customerTypeId) throws CoMaSwDataAccessException {
		DSLContext create = DSL.using(ds, SQLDialect.POSTGRES);
		List<CtCustomerType> result = null;
		String errorMessage;

		try {
			result = create.selectFrom(CT_CUSTOMER_TYPE)
					.where(CT_CUSTOMER_TYPE.CUSTOMER_TYPE_ID.eq(val(customerTypeId))).orderBy(CT_CUSTOMER_TYPE.CODE)
					.fetch().into(CtCustomerType.class);

			if (result.size() > 1) {
				errorMessage = "Error while try to find the customer type for customer_type_id : " + customerTypeId
						+ " - The query returns a distinct number of rows (" + result.size() + ") than expected (1) ";
				logger.error(errorMessage);
				throw new CoMaSwDataAccessException(errorMessage);
			} else {
				if (result.size() == 0) {
					return null;
				} else {
					return result.get(0);
				}
			}

		} catch (DataAccessException e) {
			errorMessage = "Error while try to find the customer type for customer_type_id: " + customerTypeId + " - "
					+ e.getMessage();
			logger.error(errorMessage);
			throw new CoMaSwDataAccessException(errorMessage, e);
		}

	}

	@Override
	public CtCustomerType findDataByCode(String code) throws CoMaSwDataAccessException {
		DSLContext create = DSL.using(ds, SQLDialect.POSTGRES);
		List<CtCustomerType> result = null;
		String errorMessage;

		try {
			result = create.selectFrom(CT_CUSTOMER_TYPE).where(CT_CUSTOMER_TYPE.CODE.eq(val(code)))
					.orderBy(CT_CUSTOMER_TYPE.CODE).fetch().into(CtCustomerType.class);

			if (result.size() > 1) {
				errorMessage = "Error while try to find the customer type for code : " + code
						+ " - The query returns a distinct number of rows (" + result.size() + ") than expected (1) ";
				logger.error(errorMessage);
				throw new CoMaSwDataAccessException(errorMessage);
			} else {
				if (result.size() == 0) {
					return null;
				} else {
					return result.get(0);
				}
			}
		} catch (DataAccessException e) {
			errorMessage = "Error while try to find the customer type for code " + code + " - " + e.getMessage();
			logger.error(errorMessage);
			throw new CoMaSwDataAccessException(errorMessage, e);
		}

	}

	@Override
	public void insertData(CtCustomerType dataObject) throws CoMaSwDataAccessException {
		String errorMessage;
		try {
			Configuration configuration = new DefaultConfiguration().set(ds.getConnection()).set(SQLDialect.POSTGRES);
			CtCustomerTypeDao daoObject = new CtCustomerTypeDao(configuration);
			daoObject.insert(dataObject);
		} catch (Exception e) {
			errorMessage = "Error inserting the customer type object (value: " + dataObject.toString() + ") - "
					+ e.getMessage();
			logger.error(errorMessage);
			throw new CoMaSwDataAccessException(errorMessage, e);
		}

	}

	@Override
	public void updateData(CtCustomerType dataObject) throws CoMaSwDataAccessException {
		String errorMessage;
		try {
			Configuration configuration = new DefaultConfiguration().set(ds.getConnection()).set(SQLDialect.POSTGRES);
			CtCustomerTypeDao daoObject = new CtCustomerTypeDao(configuration);
			daoObject.update(dataObject);
		} catch (Exception e) {
			errorMessage = "Error updating the customer type object (value: " + dataObject.toString() + ") - "
					+ e.getMessage();
			logger.error(errorMessage);
			throw new CoMaSwDataAccessException(errorMessage, e);
		}

	}

	@Override
	public void deleteData(CtCustomerType dataObject) throws CoMaSwDataAccessException {
		String errorMessage;
		try {
			Configuration configuration = new DefaultConfiguration().set(ds.getConnection()).set(SQLDialect.POSTGRES);
			CtCustomerTypeDao daoObject = new CtCustomerTypeDao(configuration);
			daoObject.delete(dataObject);
		} catch (Exception e) {
			errorMessage = "Error deleting the customer type object (value: " + dataObject.toString() + ") - "
					+ e.getMessage();
			logger.error(errorMessage);
			throw new CoMaSwDataAccessException(errorMessage, e);
		}

	}

}
