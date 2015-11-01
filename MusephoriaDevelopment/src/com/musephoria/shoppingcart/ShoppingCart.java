/**
 * 
 */
package com.musephoria.shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import com.musephoria.webserviceclient.ProductCatalogServiceStub.Cd;
import com.musephoria.webserviceclient.*;


/**
 * @author computer
 *
 */
public class ShoppingCart {

	public List<Cd> cdList;
	public float totalPrice;
	public float tax;
	public int totalQuantity;
	
	
	public ShoppingCart(){
		cdList = new ArrayList<Cd>();
		totalPrice = 0.00f;
		tax = 0.00f;
		totalQuantity = 0;
	}
	
	
	
	public float getTax() {
		return tax;
	}


	public void setTax(float tax) {
		this.tax = tax;
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
		tax = (float) (cdObj.getPrice() * 0.13);
		totalPrice = totalPrice + tax + cdObj.getPrice();
		totalQuantity += 1;
		
	}
	
	public void removeFromCart(int Id) {
		
		Cd toremove = null;
		
		ListIterator<Cd> looper = cdList.listIterator();
		
		while(looper.hasNext()){
			toremove = looper.next();
			int check = toremove.getCdId();
			//System.out.println(check);
			if(check == Id){
				tax = (float) (toremove.getPrice() * .13);
				totalPrice =totalPrice - (tax + toremove.getPrice());
				totalQuantity -=1;
				looper.remove();
				break;
			}
		}
		
	}
	
}