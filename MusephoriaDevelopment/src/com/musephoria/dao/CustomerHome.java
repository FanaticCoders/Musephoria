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

			resObj = dbManager.ExecuteSQL(Constants.checkIfUserExists, parameterList);

			if (!resObj.equals(null)) {
				if (resObj.getResultCount() >= 1) {
					flag = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbManager.CleanUpSession();
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
	public Result createAccount(Customer customer) {
		Result resObj = null;
		if (!customer.equals(null)) {
			resObj = dbManager.SaveNewData(customer);
		}
		dbManager.CleanUpSession();
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
	public Result getAccount(Customer customer) {
		List<String> accountInfo = new ArrayList<String>();
		if (!customer.equals(null)) {
			accountInfo.add(customer.getUserName());
		}
		Result resObj = dbManager.GetQueryResult(Constants.getAccountInfo, accountInfo);

		dbManager.CleanUpSession();
		return resObj;

	}
}
