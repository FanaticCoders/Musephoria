/**
 * 
 */
package com.musephoria.dao;

import com.musephoria.entity.Cart;

/**
 * @author computer
 *
 */
public interface IOrderHome {
	
	public boolean createOrder(Cart cartinfo, String shippinginfo);

}
