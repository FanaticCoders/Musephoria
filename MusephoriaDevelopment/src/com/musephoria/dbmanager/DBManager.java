/**
 *
 */
package com.musephoria.dbmanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.cfg.Configuration;

import com.musephoria.entity.Result;
import com.musephoria.helper.Helper;
import com.musephoria.util.Constants;

/**
 * @author FanaticCoders
 *
 *
 */

public class DBManager {

	private Configuration hConfig;
	private Session hSession;
	private Transaction hTransaction;
	private static final Log log = LogFactory.getLog(DBManager.class);

	/**
	 * Constructor of Native Class. Used to initialise the connection.
	 */
	public DBManager() {
		loadConfiguration();
		loadSession();
		beginTransaction();
	}

	/**
	 * Loads SQL configuration information from the hibernate configuration
	 * file.
	 *
	 * @return Hibernate configuration object.
	 */
	public Configuration loadConfiguration() {
		hConfig = new Configuration();
		return hConfig.configure(Constants.hibernatePropertyFile);
	}

	/**
	 * Opens a Hibernate Session.
	 *
	 * @param config
	 * @return Hibernate Session Object.
	 */
	public Session loadSession() {
		try {
			if (!hConfig.equals(null)) {
				SessionFactory hSessionFactory = hConfig.buildSessionFactory();
				hSession = hSessionFactory.openSession();
			}
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return hSession;
	}

	/**
	 * Begins a Hibernate Transaction.
	 *
	 * @param hSession
	 * @return Hibernate Transaction Object.
	 */
	public Transaction beginTransaction() {
		try {
			if (!hSession.equals(null)) {
				hTransaction = hSession.beginTransaction();
			}
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage(), e);

		}
		return hTransaction;
	}

	/**
	 * Terminates the Transaction & Closes the Session.
	 *
	 * @param hTransaction
	 * @param hSession
	 */
	public void cleanUpSession() {
		if (!hTransaction.equals(null) && !hSession.equals(null)) {
			try {
				hSession.flush();
				hTransaction.commit();
				hSession.close();
			} catch (TransactionException e) {
				log.error(e.getLocalizedMessage(), e);
			}

			catch (SessionException e) {
				log.error(e.getLocalizedMessage(), e);
			}
		}
	}

	/**
	 * Executes query and returns the number of rows affected in the result
	 * object.
	 *
	 * @param queryID
	 * @param parameterList
	 * @return resObj
	 */
	public Result executeSQL(String queryID, List<?> parameterList) {
		Result resObj = null;
		Query hQuery = null;

		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
		String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID, parameterList);

		try {
			if (!sqlQuery.isEmpty()) {
				hQuery = hSession.createQuery(sqlQuery);
				log.info(Constants.executeSQLQueryExecuted);
			}

			// Setting the result object with no of rows affected & success
			// code/message.
			resObj = setResultObject(null, null, hQuery.list().size(), Constants.successCode, Constants.successMessage);

		} catch (Exception e) {
			// Setting the result object with failure code/message.
			resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.connectionFailed + e.getMessage());
			log.error(e.getLocalizedMessage(), e);
		}
		return resObj;
	}

	/**
	 * Executes query and returns result set.
	 *
	 * @param queryID
	 * @param parameterList
	 * @return resObj
	 */
	public Result getQueryResult(String queryID, List<?> parameterList) {
		Result resObj = null;
		Query hQuery = null;

		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
		String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID, parameterList);

		try {
			if (!sqlQuery.isEmpty()) {
				hQuery = hSession.createQuery(sqlQuery);
				log.info(Constants.getQueryResultExecuted);
			}

			// Setting the result object with result set, no of rows affected &
			// success code/message.
			resObj = setResultObject(hQuery.list(), null, hQuery.list().size(), Constants.successCode,
					Constants.successMessage);
		} catch (Exception e) {
			// Setting the result object with failure code/message.
			resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.connectionFailed + e.getMessage());
			log.error(e.getLocalizedMessage(), e);
		}
		return resObj;
	}

	/**
	 * Saves new data.
	 *
	 * @param dataList
	 * @return
	 */

	public Result saveNewData(List<?> dataList) {
		Result resObj = null;
		int i = 0;
		List<Integer> primaryIdList = new ArrayList<Integer>();
		try {
			if (!dataList.equals(null)) {
				{
					// Iterating the items in the list.
					Iterator<?> item = dataList.iterator();
					while (item.hasNext()) {
						i = (int) hSession.save(item.next());
						primaryIdList.add(i);
						log.info(Constants.saveMethodExecuted);
					}
				}
			}

			// Setting the result object with success information.
			resObj = setResultObject(null, primaryIdList, primaryIdList.size(), Constants.successCode,
					Constants.dataSaved);
		} catch (Exception e) {
			// Setting the result object with failure information.
			resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.dataNotSaved);
			log.error(e.getLocalizedMessage(), e);
		}

		return resObj;
	}

	/**
	 * Deletes data from DB Table.
	 *
	 * @param entityClass
	 * @param primaryKeyList
	 */

	public <T> Result DeleteData(Class<T> entityClass, List<Integer> primaryKeyList) {
		// Reference :
		// http://examples.javacodegeeks.com/enterprise-java/hibernate/delete-persistent-object-with-hibernate/
		Result resObj = null;
		if (!primaryKeyList.equals(null) && !primaryKeyList.isEmpty()) {
			Iterator<Integer> item = primaryKeyList.iterator();

			while (item.hasNext()) {
				try {
					hSession.delete(hSession.get(entityClass, item.next()));
				} catch (HibernateException e) {
					// Setting the result object with failure information.
					resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.dataDeleteFailed);
					log.error(e.getLocalizedMessage(), e);
				}
			}

			// Setting the result object with success information.
			resObj = setResultObject(null, null, 0, Constants.successCode, Constants.dataDeleted);
		}

		return resObj;
	}

	/**
	 * Updating the table based on the data passed.
	 *
	 * @param dataList
	 * @return
	 */
	// TODO This method is not functional. To be implemented.
	public Result UpdateData(List<?> dataList) {
		Result resObj = null;
		try {
			if (!dataList.equals(null)) {
				{
					for (Object item : dataList) {
						hSession.update(item);
					}

					hSession.flush();

					// hSession.update(item.next());

				}
			}

			// Setting the result object with success information.
			resObj = setResultObject(null, null, 0, Constants.successCode, Constants.dataSaved);
		} catch (Exception e) {
			// Setting the result object with failure information.
			resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.dataNotSaved);
			log.error(e.getLocalizedMessage(), e);
			System.out.println(e.getLocalizedMessage());
		}

		return resObj;
	}

	/**
	 * Method used to set the Result Object.
	 *
	 * @param resultList
	 * @param resultCount
	 * @param statusCode
	 * @param statusMessage
	 * @return resultObj
	 */
	public Result setResultObject(Object resultList, List<Integer> primaryIdList, int resultCount, int statusCode,
			String statusMessage) {
		Result resultObj = new Result();
		try {
			// Setting the result object based on the parameters passed.
			resultObj.setResultList((List<?>) resultList);
			resultObj.setPrimaryIdList(primaryIdList);
			resultObj.setResultCount(resultCount);
			resultObj.setStatusCode(statusCode);
			resultObj.setStatusMessage(statusMessage);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return resultObj;
	}
}
