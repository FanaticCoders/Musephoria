/**
 *
 */
package com.musephoria.testing;

/**
 * @author FanaticCoders
 *
 */
public class CustomerHomeConsole {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		try {

			// Do Not Delete this. For Testing
			/*
			 * ICustomerHome customerHome = new CustomerHome(); Customer
			 * accountInfo = new Customer(); accountInfo.setUserName("m1213");
			 * accountInfo.setPassword("pa1ssword");
			 * accountInfo.setCustomerName("firstname");
			 * accountInfo.setDateOfBirth(Helper.FormatDate("1989/01/25"));
			 * accountInfo.setSex(Types.Sex.Male.toString());
			 * accountInfo.setAddress("address"); accountInfo.setCity("city");
			 * accountInfo.setProvince("prov");
			 * accountInfo.setCountry("country"); accountInfo.setZipCode("zip");
			 * accountInfo.setEmail("email"); accountInfo.setPhone("phone");
			 * accountInfo.setDefaultPaymentInfo(Types.PaymentInfo.Credit.
			 * toString()); Date today = new Date();
			 * accountInfo.setTimeStamp(new Timestamp(today.getTime()));
			 * accountInfo.setIsCustomerActive(true); Result res =
			 * customerHome.createAccount(accountInfo.getUserName(),
			 * accountInfo); String status = res.getStatusMessage();
			 */

			// Do Not Delete this. For Testing
			/*
			 * List<Integer> primaryIdList = new ArrayList<Integer>();
			 * primaryIdList.add(3015); DBManager db = new DBManager();
			 * db.DeleteData(Customer.class, primaryIdList);
			 * db.cleanUpSession();
			 */

			/*
			 * CartitemHome temp = new CartitemHome();
			 * temp.deleteFromCartItem(6001);
			 */



			/*CartitemHome dao = new CartitemHome();

			List<Cartitem> primaryIdList = new ArrayList<Cartitem>();
			primaryIdList.add(temp);
			dao.updateCartItems(primaryIdList);*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}

	}

}
