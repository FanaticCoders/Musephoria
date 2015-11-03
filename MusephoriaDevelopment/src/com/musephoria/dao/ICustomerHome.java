/**
 *
 */
package com.musephoria.dao;

import com.musephoria.entity.Customer;
import com.musephoria.entity.Result;

/**
 * @author Admin
 *
 */
public interface ICustomerHome {

	/**
	 * Checks if the user already exists.
	 */
	boolean checkIfAccountExists(String userName);

	/**
	 * Creates an account after checking if the user exists.
	 */
	Result createAccount(String accountName, Customer accountInfo);

	/**
	 * Retrives the account after doing basic validations. Returns error if
	 * validation fails.
	 */
	Result getAccount(String accountName, String accountPassword, Customer accountInfo);

}