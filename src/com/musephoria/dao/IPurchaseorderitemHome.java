/**
 *
 */
package com.musephoria.dao;

import java.util.List;

import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Purchaseorderitem;
import com.musephoria.entity.Result;
import com.musephoria.entity.Shipping;

/**
 * @author FanaticCoders
 *
 */
public interface IPurchaseorderitemHome {

	/**
	 * Creates a Purchase Order Item List based on the Purchase Order ID.
	 *
	 * @param purchaseOrderId
	 * @param shoppingCartInfo
	 * @return
	 */
	List<Purchaseorderitem> preparePurchaseOrderItem(Purchaseorder purchaseOrder, int[] shoppingCartInfo);

	/**
	 *
	 * @param poResObj
	 * @param shoppingCartInfo
	 * @param shippingInfo
	 * @return
	 */
	int createPurchaseOrderItem(Result poResObj, int[] shoppingCartInfo, Shipping shippingInfo);

	/**
	 * Gets the last inserted purchase order id.
	 */
	int getLastId(String queryId);

}