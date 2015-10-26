package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Customer;
import com.musephoria.entity.Result;
import com.musephoria.util.Constants;

/**
 * Home object for domain model class Customer.
 *
 * @see com.musephoria.entity.Customer
 * @author Hibernate Tools
 */
@Stateless
public class CustomerHome implements ICustomerHome {

	DBManager dbManager;

	/**
	 * Initialises the DBManager.
	 */
	public CustomerHome() {
		dbManager = new DBManager();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.musephoria.dao.ICustomerHome#CheckIfUserExists(java.lang.String)
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

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.musephoria.dao.ICustomerHome#CreateNewAccount(com.musephoria.entity.
	 * Customer, com.musephoria.entity.Customerdetail)
	 */
	@Override
	public Result createAccount(String accountName, Customer accountInfo) {
		Result resObj = new Result();

		// Checks if the userName exists in the database.
		boolean flag = checkIfAccountExists(accountName);
		if (flag) {
			resObj.setStatusCode(Constants.errorCode);
			resObj.setStatusMessage(Constants.userNameExists);
		} else {
			if (!accountInfo.equals(null)) {
				// Adding the accountInfo object into a list to be sent to save.
				try {
					List<Customer> customerList = new ArrayList<Customer>();
					customerList.add(accountInfo);
					dbManager.saveNewData(customerList);

					// Populating the result object with success codes & messages.
					resObj.setStatusCode(Constants.successCode);
					resObj.setStatusMessage(Constants.accountCreatedMessage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		}

		dbManager.cleanUpSession();
		return resObj;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.musephoria.dao.ICustomerHome#GetAccountInfo(com.musephoria.entity.
	 * Customer)
	 */
	@Override
	public Customer getAccount(String accountName, String accountPassword, Customer accountInfo) {
		Customer accountInfoResult = null;

		// adding the accountName in the parameter list
		List<String> accountInfoList = new ArrayList<String>();
		if (!accountName.isEmpty()) {
			accountInfoList.add(accountName);
		}

		Result resObj = dbManager.getQueryResult(Constants.getAccountInfo, accountInfoList);

		dbManager.cleanUpSession();

		// Extracting the accountInfo from the result list.
		if (!resObj.equals(null) && !resObj.getResultList().isEmpty()) {
			if (resObj.getResultList().iterator().hasNext()) {
				accountInfoResult = (Customer) resObj.getResultList().iterator().next();
			}
		}

		return accountInfoResult;
	}
}
