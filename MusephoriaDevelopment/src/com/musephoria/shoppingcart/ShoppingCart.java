/**
 * 
 */
package com.musephoria.shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.musephoria.webserviceclient.*;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.Cd;

/**
 * @author computer
 *
 */
public class ShoppingCart {

	public List<Cd> cdList;
	public float totalPrice;
	public ShoppingCart(){
		cdList = new ArrayList<Cd>();
		totalPrice = 0;
		
	}

	
	public List<Cd> getCdList() {
		return cdList;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	/*
	 * public ShoppingCart addToCart(List<Cd> cd){ cdList.add(e);
	 * 
	 * for(cd: cdList){ totalPrice+ = cdList.get(i).ge }
	 */
	public void addToCart(Cd cdObj) {
		cdList.add(cdObj);
		totalPrice += cdObj.getPrice();
		
	}
	
	public void removeFromCart(int Id) {
		
		Cd toremove = null;
		
		ListIterator<Cd> looper = cdList.listIterator();
		
		while(looper.hasNext()){
			toremove = looper.next();
			int check = toremove.getCdId();
			//System.out.println(check);
			if(check == Id){
				totalPrice-= toremove.getPrice();
				looper.remove();
				break;
			}
		}
		
	}
	
}