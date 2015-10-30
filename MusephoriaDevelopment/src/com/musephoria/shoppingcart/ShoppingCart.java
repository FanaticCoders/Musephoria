/**
 * 
 */
package com.musephoria.shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
		
		Iterator<Cd> looper = cdList.iterator();
		int i =0;
		for(Cd item: cdList){
			
			i++;
			if(item.getCdId() == Id){
				
				
				cdList.remove(cdList.get(i));
			}
		}
		
		
		
		/*while(looper.hasNext()){
			
			int check = looper.next().getCdId();
			//System.out.println(check);
			if(looper.next().getCdId() == Id){
				totalPrice-=looper.next().getPrice();
				looper.remove();
			}
		}*/
		
		/*cdList.remove(cdObj);
		totalPrice -= cdObj.getPrice();
*/	}
	
}