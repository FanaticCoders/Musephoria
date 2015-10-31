/**
 *
 */
package com.musephoria.webserviceclient;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.Cd;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.GetCategoryList;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.GetCategoryListResponse;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.GetProductInfo;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.GetProductInfoResponse;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.GetProductList;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.GetProductListResponse;

/**
 * @author FanaticCoders
 *
 */
public class ProductCatalogServiceClient {

	private static final Log log = LogFactory.getLog(DBManager.class);

	/**
	 * Gets the Category List.
	 *
	 * @return
	 */
	public String[] getCategoryList() {
		String[] categoryList = null;

		try {
			ProductCatalogServiceStub stub = new ProductCatalogServiceStub();

			// Calling the WebService to capture the response.
			GetCategoryListResponse response = stub.getCategoryList(new GetCategoryList());
			categoryList = response.get_return();

		} catch (RemoteException e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return categoryList;
	}

	/**
	 * Gets the Product list when a CategoryId/Genre is specified. Else all
	 * Products are returned.
	 *
	 * @param categoryId
	 * @return
	 */
	public Cd[] getProductList(String categoryId) {
		Cd[] productList = null;
		try {
			ProductCatalogServiceStub stub = new ProductCatalogServiceStub();

			// Setting the parameters in the get product list parameter object.
			GetProductList parameter = new GetProductList();
			if (!categoryId.isEmpty()) {
				parameter.setCategoryId(categoryId);
			}

			// Calling the WebService to capture the response.
			GetProductListResponse response = stub.getProductList(parameter);
			productList = response.get_return();

		} catch (RemoteException e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return productList;
	}

	/**
	 * Gets the product info based on the product id.
	 *
	 * @param productId
	 * @return
	 */
	public Cd getProductInfo(int productId) {
		Cd productInfo = null;
		try {
			ProductCatalogServiceStub stub = new ProductCatalogServiceStub();

			// Setting the parameters in the get product info parameter object.
			GetProductInfo parameter = new GetProductInfo();
			if (productId > 0) {
				parameter.setProductId(productId);
			}

			// Calling the WebService to capture the response.
			GetProductInfoResponse response = stub.getProductInfo(parameter);
			productInfo = response.get_return();

		} catch (RemoteException e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return productInfo;
	}

}
