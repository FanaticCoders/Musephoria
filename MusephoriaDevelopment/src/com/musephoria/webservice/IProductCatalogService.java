/**
 *
 */
package com.musephoria.webservice;

import com.musephoria.entity.Result;

/**
 * @author FanaticCoders
 *
 */
public interface IProductCatalogService {
	public Result getCategoryList();

	public Result getProductList(int categoryId);

	public Result getProductInfo(int productid);
}
