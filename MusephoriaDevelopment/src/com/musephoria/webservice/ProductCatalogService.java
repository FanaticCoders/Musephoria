/**
 *
 */
package com.musephoria.webservice;

import java.util.List;

import com.musephoria.dao.CdHome;
import com.musephoria.entity.Cd;

/**
 * @author Admin
 *
 */
public class ProductCatalogService implements IProductCatalogService {

	/* (non-Javadoc)
	 * @see com.musephoria.webservice.IProductCatalogService#getCategoryList()
	 */
	@Override
	public List<String> getCategoryList() {
		CdHome cdDao = new CdHome();
		List<String> categoryList = cdDao.getCategoryList();
		return categoryList;
	}

	/* (non-Javadoc)
	 * @see com.musephoria.webservice.IProductCatalogService#getProductList(java.lang.String)
	 */
	@Override
	public List<Cd> getProductList(String categoryId) {
		CdHome cdDao = new CdHome();
		List<Cd> productList = cdDao.getProductList(categoryId);
		return productList;
	}

	/* (non-Javadoc)
	 * @see com.musephoria.webservice.IProductCatalogService#getProductInfo(int)
	 */
	@Override
	public Cd getProductInfo(int productId) {
		CdHome cdDao = new CdHome();
		Cd productInfo = cdDao.getProductInfo(productId);
		return productInfo;
	}

}
