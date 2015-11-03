package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Customer;
import com.musephoria.entity.Result;
import com.musephoria.util.Constants;

/**
 * Home object for domain model class Customer.
 *
 * @see com.musephoria.entity.Customer
 * @author FanatiicCoders
 */
@Stateless
public class CustomerHome implements ICustomerHome {

	DBManager dbManager;
	private static final Log log = LogFactory.getLog(CustomerHome.class);

	/**
	 * Initialises the DBManager.
	 */
	public CustomerHome() {
		dbManager = new DBManager();
	}

	/**
	 * Checks if the user already exists.
	 */
	@Override
	public boolean checkIfAccountExists(String userName) {
		boolean flag = false;
		Result resObj = null;
		try {

			List<String> parameterList = new ArrayList<String>();
			if (!userName.isEmpty()) {
				parameterList.add(userName);
			}

			resObj = dbManager.executeSQL(Constants.checkIfUserExists, parameterList);

			if (!resObj.equals(null)) {
				if (resObj.getResultCount() >= 1) {
					flag = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * Creates an account after checking if the user exists.
	 */
	@Override
	public Result createAccount(String accountName, Customer accountInfo) {
		Result resObj = new Result();

		// Checks if the userName exists in the database.
		boolean flag = checkIfAccountExists(accountName);
		if (flag) {
			// Setting the error codes & messages.
			resObj.setStatusCode(Constants.errorCode);
			resObj.setStatusMessage(Constants.userNameExist);
		} else {
			if (!accountInfo.equals(null)) {
				// Adding the accountInfo object into a list to be sent to save.
				try {
					List<Customer> customerList = new ArrayList<Customer>();
					customerList.add(accountInfo);
					Result tempResObj = dbManager.saveNewData(customerList);

					if (!tempResObj.equals(null)) {
						if (tempResObj.getStatusMessage().equals(Constants.dataSaved)) {
							// Populating the result object with account created
							// message.
							resObj.setStatusMessage(Constants.accountCreatedMessage);
						}
					}

				} catch (Exception e) {
					log.error(e.getLocalizedMessage(), e);
				}

			}
		}

		dbManager.cleanUpSession();
		return resObj;

	}

	/**
	 * Retrives the account after doing basic validations. Returns error if validation fails.
	 */
	@Override
	public Result getAccount(String accountName, String accountPassword, Customer accountInfo) {
		Result resObj = new Result();

		// Checks if the userName exists in the database.
		boolean flag = checkIfAccountExists(accountName);

		if (flag) {
			// adding the accountName in the parameter list
			List<String> accountInfoList = new ArrayList<String>();
			if (!accountName.isEmpty()) {
				accountInfoList.add(accountName);
			}

			if (!accountPassword.isEmpty()) {
				accountInfoList.add(accountPassword);
			}

			Result tempResObj = dbManager.getQueryResult(Constants.getAccountInfo, accountInfoList);

			if (!tempResObj.equals(null)) {
				if (tempResObj.getResultCount() > 0) {
					// User is Validated. Populate result object with success
					// messages.
					resObj.setResultList(tempResObj.getResultList());
					resObj.setStatusCode(Constants.successCode);
					resObj.setStatusMessage(Constants.userIsValidated);
				} else {
					// Bad Credentials. Populate result object with error
					// messages.
					resObj.setStatusCode(Constants.errorCode);
					resObj.setStatusMessage(Constants.userNamePasswordMismatch);
				}
			}

		} else {
			// User doesnt exists. Set result object with appropriate Error
			// Messages.
			resObj.setStatusCode(Constants.errorCode);
			resObj.setStatusMessage(Constants.userNameDoesntExist);
		}

		dbManager.cleanUpSession();
		return resObj;
	}
}
