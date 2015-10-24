/**
 * 
 */
package com.musephoria.dao;

import com.musephoria.entity.Customerdetail;
import com.musephoria.entity.Result;

/**
 * @author Admin
 *
 */
public interface ICustomerdetailHome {

	Result saveCustomerDetails(Customerdetail customerdetail);

	Customerdetail getCustomerDetails(int customerId);

}