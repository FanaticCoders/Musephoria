package com.musephoria.dao;
// default package

// Generated Oct 29, 2015 12:25:06 AM by Hibernate Tools 4.0.0.Final

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.entity.Cd;
import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Purchaseorderitem;

/**
 * Home object for domain model class Purchaseorderitem.
 *
 * @see .Purchaseorderitem
 * @author Hibernate Tools
 */
@Stateless
public class PurchaseorderitemHome {

	private static final Log log = LogFactory.getLog(PurchaseorderitemHome.class);

	/**
	 * Creates a Purchase Order Item List based on the Purchase Order ID.
	 *
	 * @param purchaseOrderId
	 * @param shoppingCartInfo
	 * @return
	 */
	public List<Purchaseorderitem> createPurchaseOrderItem(Purchaseorder purchaseOrder,
			List<Integer> shoppingCartInfo) {
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

}
