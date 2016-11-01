/**
 *
 */
package com.musephoria.dao;

import java.util.List;

import com.musephoria.entity.Cd;

/**
 * @author FanaticCoders
 *
 */
public interface ICdHome {

	/**
	 * Gets the category list from the database.
	 *
	 * @return
	 */

	List<String> getCategoryList();

	/**
	 * Gets the product list based on category id.
	 *
	 * @param categoryId
	 * @return
	 */
	List<Cd> getProductList(String categoryId);

	/**
	 * Get Product Info based on the product id.
	 *
	 * @param productId
	 * @return
	 */
	Cd getProductInfo(int productId);

}