/**
 *
 */
package com.musephoria.webservice;

import java.util.List;

import com.musephoria.dao.CdHome;
import com.musephoria.entity.Cd;

/**
 * @author FanaticCoders
 *
 */
public class ProductCatalogService implements IProductCatalogService {

	/**
	 * Gets all the list of catagories.
	 */
	@Override
	public List<String> getCategoryList() {
		CdHome cdDao = new CdHome();
		List<String> categoryList = cdDao.getCategoryList();
		return categoryList;
	}

	/**
	 * Gets the list of products based on the category id. If category id is
	 * empty then all products are returned.
	 */
	@Override
	public List<Cd> getProductList(String categoryId) {
		CdHome cdDao = new CdHome();
		List<Cd> productList = cdDao.getProductList(categoryId);
		return productList;
	}

	/**
	 * Gets the information of a product based on the product id.
	 */
	@Override
	public Cd getProductInfo(int productId) {
		CdHome cdDao = new CdHome();
		Cd productInfo = cdDao.getProductInfo(productId);
		return productInfo;
	}

}
