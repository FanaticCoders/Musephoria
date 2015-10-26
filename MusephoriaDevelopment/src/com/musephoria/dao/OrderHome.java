package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;

//import com.ibm.wsdl.Constants;
import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Cart;
import com.musephoria.entity.Cartitem;
import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Result;
import com.musephoria.util.Constants;


/**
 * Home object for domain model class Order.
 * @see com.musephoria.entity.Order
 * @author Hibernate Tools
 */
@Stateless
public class OrderHome implements IOrderHome{

	DBManager dbManager;

	public OrderHome(){
		dbManager = new DBManager();
	}


	@Override
	public boolean createOrder(Cart cartinfo, String shippinginfo){
		Result resobj1, resobj2;
		Purchaseorder po = new Purchaseorder();
		boolean flag = false;
		try{
			List<Integer> parameterList = new ArrayList<Integer>();
			parameterList.add(cartinfo.getCartId());

			//Fetching the CartItems
			resobj1 = dbManager.getQueryResult(Constants.getCartItems, parameterList);

			if(resobj1!=null && !resobj1.getResultList().isEmpty()){

				@SuppressWarnings("unchecked")
				Iterator<Cartitem> resitr = (Iterator<Cartitem>) resobj1.getResultList().iterator();

				// Populating the Purchase Order
				while(resitr.hasNext()){
					po.setCustomer(cartinfo.getCustomer());
					po.setPurchaseOrderItem(resitr.next().getCardItemName());
					po.setQuantity(resitr.next().getQuantity());
					po.setBaseAmount(resitr.next().getBaseAmount());
					po.setShippingAddress(shippinginfo);
					po.setPurchaseOrderStatus("Ordered");
					po.setIsPurchaseOrderActive(true);
				}

				List<Purchaseorder> PurchaseOrderList = new ArrayList<Purchaseorder>();
				PurchaseOrderList.add(po);

				// Inserting Purchase Order into Database
				resobj2 = dbManager.saveOrUpdateData(PurchaseOrderList);

				//Setting flag if the Purchase Order is inserted
				if(resobj2.getStatusCode() == 1){
					flag = true;
				}

		      }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
		}
}
