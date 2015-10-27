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
	public List<String> getCategoryList();

	public List<Cd> getProductList(String categoryId);

	public Cd getProductInfo(int productId);
}
