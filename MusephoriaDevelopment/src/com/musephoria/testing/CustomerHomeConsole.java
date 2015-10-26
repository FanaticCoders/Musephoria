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
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {

			ICustomerHome customerHome = new CustomerHome();
			Customer customer = new Customer();
			customer.setUserName("ajay");
			customer.setPassword("1232");
			customer.setSex(Types.Sex.Male.toString());
			customer.setDateOfBirth(Helper.FormatDate("1988/01/27"));
			customer.setDefaultPaymentInfo(Types.PaymentInfo.Credit.toString());
			customer.setIsCustomerActive(true);
			Date today = new Date();
			customer.setTimeStamp(new Timestamp(today.getTime()));

			// boolean flag = name.checkIfAccountExists(name1.getUserName());
			// System.out.println(flag);

			/*Iterator<Customer> temp = (Iterator<Customer>) customerHome.getAccount(customer).getResultList().iterator();
			Customer cust = temp.next();
			System.out.println(cust.getCustomerId());*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}

	}

}
