/**
 *
 */
package com.musephoria.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Entity;

import com.musephoria.entity.Cd;



/**
 * @author computer
 *
 */
@Entity
public class ShoppingCart {

	public int customerId;
	public float totalPrice;
	public float tax;
	public List<Cd> cdList;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
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

	public void setCdList(List<Cd> cdList) {
		this.cdList = cdList;
	}


	public ShoppingCart(){
		cdList = new ArrayList<Cd>();
		totalPrice = 0;

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