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
import com.musephoria.shoppingcart.ShoppingCart;

/**
 * Home object for domain model class Purchaseorderitem.
 *
 * @see .Purchaseorderitem
 * @author Hibernate Tools
 */
@Stateless
public class PurchaseorderitemHome {


	private static final Log log = LogFactory.getLog(PurchaseorderitemHome.class);

	public List<Purchaseorderitem> createPurchaseOrderItem(int purchaseOrderId, ShoppingCart shoppingCartInfo) {
		List<Purchaseorderitem> purchaseOrderItemList = new ArrayList<Purchaseorderitem>();
		try {
			if (purchaseOrderId > 0 && !shoppingCartInfo.equals(null)) {
				if (!shoppingCartInfo.getCdList().isEmpty()) {

					// Setting the PO Obeject with PO ID.
					Purchaseorder tempPurchaseOrderObj = new Purchaseorder();
					tempPurchaseOrderObj.setPurchaseOrderId(purchaseOrderId);

					for (Cd item : shoppingCartInfo.getCdList()) {
						// Creating a POI Object.
						Purchaseorderitem purchaseOrderItem = new Purchaseorderitem();

						// Setting PO Id.
						purchaseOrderItem.setPurchaseorder(tempPurchaseOrderObj);

						// Setting the POI with Cd Id.
						Cd tempCdObj = new Cd();
						tempCdObj.setCdId(item.getCdId());
						purchaseOrderItem.setCd(tempCdObj);

						// Setting the POI with other Cd attributes.
						purchaseOrderItem.setPurchaseOrderItemName(item.getName());
						purchaseOrderItem.setBaseAmount(item.getPrice());

						// Adding every individual cd into POI List.
						purchaseOrderItemList.add(purchaseOrderItem);

					}
				}
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}

		return purchaseOrderItemList;
	}

}
