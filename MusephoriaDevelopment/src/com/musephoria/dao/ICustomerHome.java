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
	 * Creates a new Account.
	 *
	 * @param accountName
	 * @param accountInfo
	 * @return
	 */
	Result createAccount(String accountName, Customer accountInfo);

	/**
	 * Gets the account information.
	 *
	 * @param accountName
	 * @param accountPassword
	 * @param accountInfo
	 * @return
	 */
	Customer getAccount(String accountName, String accountPassword, Customer accountInfo);

}