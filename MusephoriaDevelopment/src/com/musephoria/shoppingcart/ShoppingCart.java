/**
 * 
 */
package com.musephoria.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import com.musephoria.entity.Cd;

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

}
