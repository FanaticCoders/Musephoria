package com.musephoria.dao;
// default package

import java.util.ArrayList;
import java.util.List;

// Generated Oct 29, 2015 12:25:06 AM by Hibernate Tools 4.0.0.Final

import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Customer;
import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Purchaseorderitem;
import com.musephoria.entity.Result;
import com.musephoria.entity.Shipping;
import com.musephoria.shoppingcart.ShoppingCart;
import com.musephoria.util.Constants;
import com.musephoria.util.Types;

/**
 * Home object for domain model class Purchaseorder.
 *
 * @see .Purchaseorder
 * @author Hibernate Tools
 */
@Stateless
public class PurchaseorderHome {

	DBManager dbManager;
	private static final Log log = LogFactory.getLog(PurchaseorderHome.class);

	/**
	 * Initialises the DBManager.
	 */
	public PurchaseorderHome() {
		dbManager = new DBManager();
	}

	public Result createOrder(ShoppingCart shoppingCartInfo, Shipping shippingInfo) {

		Result poiResObj = null;

		try {
			if (!shoppingCartInfo.equals(null)) {

				// Creating an object of Purchase Order(PO).
				Purchaseorder purchaseOrder = new Purchaseorder();

				// Setting the customer id in PO object.
				Customer customer = new Customer();
				customer.setCustomerId(shoppingCartInfo.getCustomerId());
				purchaseOrder.setCustomer(customer);

				// Setting other parameters of the PO object from shopping cart object.
				purchaseOrder.setTotalQuantity(shoppingCartInfo.getCdList().size());
				purchaseOrder.setTotalPrice(shoppingCartInfo.getTotalPrice());
				purchaseOrder.setTaxes(shoppingCartInfo.getTax());
				purchaseOrder.setPurchaseOrderStatus(Types.PurchaseOrder.Ordered.toString());

				List<Purchaseorder> purchaseOrderList = new ArrayList<Purchaseorder>();
				purchaseOrderList.add(purchaseOrder);

				// Saving the purchase order.
				Result poResObj = dbManager.saveNewData(purchaseOrderList);

				if (!poResObj.equals(null)) {
					if (poResObj.getStatusMessage().equals(Constants.dataSaved)
							&& poResObj.getPrimaryIdList().size() > 0) {
						// Fetching the purchase order id.
						int purchaseOrderId = poResObj.getPrimaryIdList().get(0);

						// Creating a POI List to be saved.
						PurchaseorderitemHome poDao = new PurchaseorderitemHome();
						List<Purchaseorderitem> purchaseOrderItemList = poDao.createPurchaseOrderItem(purchaseOrderId,
								shoppingCartInfo);

						// Saving the POI List.
						poiResObj = dbManager.saveNewData(purchaseOrderItemList);

					}
				}

			}

			dbManager.cleanUpSession();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}

		return poiResObj;
	}

}
