/**
 *
 */
package com.musephoria.webservice;

import java.util.List;

import com.musephoria.entity.Cd;

/**
 * @author FanaticCoders
 *
 */
public interface IProductCatalogService {
	/**
	 *
	 * Gets all the list of catagories.
	 *
	 * @return
	 */
	public List<String> getCategoryList();

	/**
	 * Gets the list of products based on the category id. If category id is
	 * empty then all products are returned.
	 *
	 * @param categoryId
	 * @return
	 */
	public List<Cd> getProductList(String categoryId);

	/**
	 * Gets the information of a product based on the product id.
	 *
	 * @param productId
	 * @return
	 */
	public Cd getProductInfo(int productId);
}
