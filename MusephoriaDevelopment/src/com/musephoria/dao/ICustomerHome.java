/**
 *
 */
package com.musephoria.dao;

import com.musephoria.entity.Customer;
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
	boolean checkIfAccountExists(String userName);

	/**
	 * Creates a New Account
	 *
	 * @param customer
	 * @param customerDetail
	 * @return
	 */
	Result createAccount(Customer customer);

	/**
	 * Gets the account information.
	 *
	 * @param customer
	 * @return
	 */
	Result getAccount(Customer customer);

}