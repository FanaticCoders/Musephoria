/**
 *
 */
package com.musephoria.dbmanager;

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

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
 */

public class DBManager {

	private Configuration hConfig;
	private Session hSession;
	private Transaction hTransaction;

	/**
	 * Constructor of Native Class. Used to initialise the connection.
	 */
	public DBManager() {
		LoadConfiguration();
		LoadSession();
		BeginTransaction();
	}

	/**
	 * Loads SQL configuration information from the hibernate configuration
	 * file.
	 *
	 * @return Hibernate configuration object.
	 */
	public Configuration LoadConfiguration() {
		hConfig = new Configuration();
		return hConfig.configure("hibernate.cfg.xml");
	}

	/**
	 * Opens a Hibernate Session.
	 *
	 * @param config
	 * @return Hibernate Session Object.
	 */
	public Session LoadSession() {
		if (!hConfig.equals(null)) {
			SessionFactory hSessionFactory = hConfig.buildSessionFactory();
			hSession = hSessionFactory.openSession();
		}
		return hSession;
	}

	/**
	 * Begins a Hibernate Transaction.
	 *
	 * @param hSession
	 * @return Hibernate Transaction Object.
	 */
	public Transaction BeginTransaction() {
		if (!hSession.equals(null)) {
			hTransaction = hSession.beginTransaction();
		}
		return hTransaction;
	}

	/**
	 * Terminates the Transaction & Closes the Session.
	 *
	 * @param hTransaction
	 * @param hSession
	 */
	public void CleanUpSession() {
		try {
			if (!hTransaction.equals(null) && !hSession.equals(null)) {
				hSession.flush();
				hTransaction.commit();
				hSession.close();
			}
		}

		catch (TransactionException ex) {
			Helper.LogError(ex, Level.FINER);
		}

		catch (SessionException ex) {
			Helper.LogError(ex, Level.FINER);
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
	public Result ExecuteSQL(String queryID, List<String> parameterList) {
		Result resObj = null;
		Query hQuery = null;
		try {
			Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
			String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID, parameterList);
			if (!sqlQuery.isEmpty()) {
				hQuery = hSession.createQuery(sqlQuery);

			}

			resObj = SetResultObject(null, hQuery.list().size(), Constants.successCode, Constants.successMessage);
		} catch (Exception e) {
			resObj = SetResultObject(null, 0, Constants.errorCode, Constants.connectionFailed + e.getMessage());
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
	public Result GetQueryResult(String queryID, List<String> parameterList) {
		Result resObj = null;
		Query hQuery = null;
		try {
			Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
			String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID, parameterList);
			if (!sqlQuery.isEmpty()) {
				hQuery = hSession.createQuery(sqlQuery);
			}

			resObj = SetResultObject(hQuery.list(), hQuery.list().size(), Constants.successCode,
					Constants.successMessage);

		} catch (Exception e) {
			resObj = SetResultObject(null, 0, Constants.errorCode, Constants.connectionFailed + e.getMessage());
		}
		return resObj;
	}

	/**
	 * Save fresh/new data.
	 *
	 * @param objList
	 * @return resObj
	 */
	public Result SaveNewData(List<?> objList) {
		Result resObj = null;
		try {
			if (objList != null) {
				for (Object item : objList) {
					if (item != null) {
						hSession.save(item);
					}
				}
			}
			resObj = SetResultObject(null, 0, Constants.successCode, Constants.dataSaved);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
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
	public Result SetResultObject(Object resultList, int resultCount, int statusCode, String statusMessage) {
		Result resultObj = null;
		try {
			resultObj = new Result();
			resultObj.setResultList((List<?>) resultList);
			resultObj.setResultCount(resultCount);
			resultObj.setStatusCode(statusCode);
			resultObj.setStatusMessage(statusMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultObj;
	}
}
