package com.musephoria.dao;
// default package

// Generated Oct 29, 2015 12:25:06 AM by Hibernate Tools 4.0.0.Final

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Cd;
import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Purchaseorderitem;
import com.musephoria.entity.Result;
import com.musephoria.entity.Shipping;
import com.musephoria.util.Constants;

/**
 * Home object for domain model class Purchaseorderitem.
 *
 * @see .Purchaseorderitem
 * @author Hibernate Tools
 */
@Stateless
public class PurchaseorderitemHome {

	DBManager dbManager;
	private static final Log log = LogFactory.getLog(PurchaseorderHome.class);

	/**
	 * Initialises the DBManager.
	 */
	public PurchaseorderitemHome() {
		dbManager = new DBManager();
	}

	/**
	 * Creates a Purchase Order Item List based on the Purchase Order ID.
	 *
	 * @param purchaseOrderId
	 * @param shoppingCartInfo
	 * @return
	 */
	public List<Purchaseorderitem> createPurchaseOrderItem(Purchaseorder purchaseOrder, int[] shoppingCartInfo) {

		List<Purchaseorderitem> purchaseOrderItemList = new ArrayList<Purchaseorderitem>();
		try {
			if (purchaseOrder.getPurchaseOrderId() > 0 && !shoppingCartInfo.equals(null)) {
				for (int item : shoppingCartInfo) {
					// Creating a POI Object.
					Purchaseorderitem purchaseOrderItem = new Purchaseorderitem();

					// Setting PO Id in POI
					purchaseOrderItem.setPurchaseorder(purchaseOrder);

					// Setting the POI with Cd Id.
					Cd cdObj = new Cd();
					cdObj.setCdId(item);
					purchaseOrderItem.setCd(cdObj);

					// Adding every individual cd into POI List.
					purchaseOrderItemList.add(purchaseOrderItem);
				}
			}

		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}

		return purchaseOrderItemList;
	}

	public int createPurchaseOrderItem(Result poResObj, int[] shoppingCartInfo, Shipping shippingInfo) {
		int purchaseOrderId = 0;
		if (!poResObj.equals(null)) {
			// Fetching the purchase order id.
			purchaseOrderId = getLastId(Constants.getLastId);

			// Setting the purchase order id to be sent to shipping
			// info & purchase order item.
			Purchaseorder newPurchaseOrderObj = new Purchaseorder();
			newPurchaseOrderObj.setPurchaseOrderId(purchaseOrderId);

			List<Purchaseorderitem> purchaseOrderItemList = createPurchaseOrderItem(newPurchaseOrderObj,
					shoppingCartInfo);

			// Saving the POI List.
			dbManager.upDateEntity(purchaseOrderItemList);

			if (!shippingInfo.equals(null)) {
				shippingInfo.setPurchaseorder(newPurchaseOrderObj);

				List<Shipping> shippingList = new ArrayList<Shipping>();
				shippingList.add(shippingInfo);

				// Saving the Shipping Info.
				dbManager.upDateEntity(shippingList);
			}
		}
		dbManager.cleanUpSession();
		return purchaseOrderId;
	}

	@SuppressWarnings("unchecked")
	public int getLastId(String queryId) {
		int id = 0;
		Result resObj = dbManager.getQueryResult(queryId, null);
		if (!resObj.equals(null)) {
			if (!resObj.getResultList().isEmpty()) {
				List<Purchaseorder> temp = (List<Purchaseorder>) resObj.getResultList();

				id = temp.get(0).getPurchaseOrderId();

			}

		}
		return id;
	}

}
