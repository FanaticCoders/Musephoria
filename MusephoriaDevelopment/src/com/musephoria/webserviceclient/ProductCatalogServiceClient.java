/**
 *
 */
package com.musephoria.webserviceclient;

import java.rmi.RemoteException;

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

	public String[] getCategoryList() {
		String[] categoryList = null;

		try {
			ProductCatalogServiceStub stub = new ProductCatalogServiceStub();
			GetCategoryListResponse response = stub.getCategoryList(new GetCategoryList());
			categoryList = response.get_return();

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categoryList;
	}

	public Cd[] getProductList(String categoryId) {
		Cd[] productList = null;
		try {
			ProductCatalogServiceStub stub = new ProductCatalogServiceStub();
			GetProductList parameter = new GetProductList();
			if (!categoryId.isEmpty()) {
				parameter.setCategoryId(categoryId);
			}

			GetProductListResponse response = stub.getProductList(parameter);
			productList = response.get_return();

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	public Cd getProductInfo(int productId) {
		Cd productInfo = null;
		try {
			ProductCatalogServiceStub stub = new ProductCatalogServiceStub();
			GetProductInfo parameter = new GetProductInfo();
			if (productId > 0) {
				parameter.setProductId(productId);
			}

			GetProductInfoResponse response = stub.getProductInfo(parameter);
			productInfo = response.get_return();

		} catch (RemoteException e) {
			System.out.println(e.getStackTrace());
		}

		return productInfo;
	}

}
