/**
 *
 */
package com.musephoria.dao;

import com.musephoria.entity.Result;

/**
 * @author FanaticCoders
 *
 */
public interface ICdHome {

	/**
	 * Gets all the category.
	 * 
	 * @return
	 */
	Result GetCategoryList();
	Result getProductList(String genre);

}

