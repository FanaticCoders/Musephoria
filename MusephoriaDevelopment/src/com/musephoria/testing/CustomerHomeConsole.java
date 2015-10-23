/**
 *
 */
package com.musephoria.testing;

import java.sql.Timestamp;
import java.util.Date;

import com.musephoria.dao.CustomerHome;
import com.musephoria.dao.ICustomerHome;
import com.musephoria.entity.Customer;
import com.musephoria.helper.Helper;
import com.musephoria.util.Types;

/**
 * @author FanaticCoders
 *
 */
public class CustomerHomeConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			ICustomerHome name = new CustomerHome();
			Customer name1 = new Customer();
			name1.setUserName("123");
			name1.setPassword("1232");
			name1.setSex(Types.Sex.Male.toString());
			name1.setDateOfBirth(Helper.FormatDate("1988/01/27"));
			name1.setDefaultPaymentInfo(Types.PaymentInfo.Credit.toString());
			name1.setIsCustomerActive(true);
			Date today = new Date();
			name1.setTimeStamp(new Timestamp(today.getTime()));

			name.CreateNewAccount(name1, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}

	}

}
