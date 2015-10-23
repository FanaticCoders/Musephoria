/**
 *
 */
package com.musephoria.dao;

import com.musephoria.entity.Customer;
import com.musephoria.entity.Customerdetail;
import com.musephoria.entity.Result;

/**
 * @author FanaticCoders
 *
 */
public interface ICustomerHome {

	/**
	 * Checks if the user exists.
	 *
	 * @param userName
	 * @return
	 */
	boolean CheckIfUserExists(String userName);

	/**
	 * Creates a New Account
	 *
	 * @param customer
	 * @param customerDetail
	 * @return
	 */
	Result CreateNewAccount(Customer customer, Customerdetail customerDetail);

	/**
	 * Gets the account information.
	 *
	 * @param customer
	 * @return
	 */
	Result GetAccountInfo(Customer customer);

}