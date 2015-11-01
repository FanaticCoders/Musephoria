package com.musephoria.dao;
// default package

import java.util.ArrayList;
import java.util.List;

// Generated Oct 29, 2015 12:25:06 AM by Hibernate Tools 4.0.0.Final

import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Paymentinfo;
import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Result;
import com.musephoria.entity.Shipping;
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

	/**
	 * Creates an order by saving Purchase order, Purchase Order Items &
	 * Shipping Information.
	 *
	 * @param shoppingCartInfo
	 * @param purchaseOrder
	 * @param shippingInfo
	 * @return
	 */
	public int createOrder(int[] shoppingCartInfo, Purchaseorder purchaseOrder, Shipping shippingInfo) {
		int purchaseOrderId = 0;
		try {
			if (!purchaseOrder.equals(null)) {
				List<Purchaseorder> purchaseOrderList = new ArrayList<Purchaseorder>();
				purchaseOrderList.add(purchaseOrder);

				// Saving the purchase order.
				Result poResObj = dbManager.upDateEntity(purchaseOrderList);
				dbManager.cleanUpSession();

				PurchaseorderitemHome poiDao = new PurchaseorderitemHome();
				purchaseOrderId = poiDao.createPurchaseOrderItem(poResObj, shoppingCartInfo, shippingInfo);

			}

		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}

		return purchaseOrderId;
	}

	/**
	 * Confirms the order based on payment info status
	 *
	 * @param purchaseOrder
	 * @param shippingInfo
	 * @param paymentInfo
	 * @return
	 */
	public boolean confirmOrder(Purchaseorder purchaseOrder, Shipping shippingInfo, Paymentinfo paymentInfo) {
		boolean flag = false;
		if (!purchaseOrder.equals(null) && !paymentInfo.getPaymentInfoStatus().isEmpty()) {
			// Setting the status in the purchase order and hardcoding the flag
			// value for approval/rejection.
			switch (paymentInfo.getPaymentInfoStatus()) {
			case "Approved":
				purchaseOrder.setPurchaseOrderStatus(Types.PurchaseOrder.Approved.toString());
				flag = true;
				break;
			case "Rejected":
				purchaseOrder.setPurchaseOrderStatus(Types.PurchaseOrder.Rejected.toString());
				flag = false;
				break;
			}

			List<Purchaseorder> purchaseOrderList = new ArrayList<Purchaseorder>();
			purchaseOrderList.add(purchaseOrder);

			// Saving the purchase order.
			dbManager.UpdateData(purchaseOrderList);
		}

		return flag;
	}


}
