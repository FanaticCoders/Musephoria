package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Customer;
import com.musephoria.entity.Customerdetail;
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
	public boolean CheckIfUserExists(String userName) {
		boolean flag = false;
		try {
			List<String> parameterList = new ArrayList<String>();

			if (!userName.isEmpty()) {
				parameterList.add(userName);
			}

			Result resObj = dbManager.ExecuteSQL(Constants.checkIfUserExists, parameterList);
			if (!resObj.equals(null)) {
				int resultCount = resObj.getResultCount();
				if (resultCount >= 1) {
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
	public Result CreateNewAccount(Customer customer, Customerdetail customerDetail) {
		boolean flag = false;
		Result resObj = null;
		List<Object> custDetailObj = new ArrayList<Object>();
		custDetailObj.add(customer);
		custDetailObj.add(customerDetail);

		if (!customer.equals(null)) {
			flag = CheckIfUserExists(customer.getUserName());
			if (flag) {
				resObj = dbManager.SetResultObject(null, 0, Constants.errorCode,
						customer.getUserName() + Constants.userNameExists);
			} else {
				resObj = dbManager.SaveNewData(custDetailObj);
			}
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
	public Result GetAccountInfo(Customer customer) {
		Result resObj = dbManager.GetQueryResult(Constants.getAccountInfo, null);
		return resObj;

	}
}
