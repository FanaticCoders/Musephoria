/**
 *
 */
package com.musephoria.testing;

import com.musephoria.dao.CdHome;
import com.musephoria.entity.Cd;

/**
 * @author Admin
 *
 */
public class CdHomeConsole {
	/**
	 * @param args
	 */

	public static void main(String[] args) {

		try {
			// Dont Delete.!!
			// Test Method for getCategoryList
			CdHome cdDaoObj = new CdHome();

			/*List<String> resObj = cdDaoObj.getCategoryList();
			Iterator<String> iterator = resObj.iterator();
			while(iterator.hasNext())
			{
				System.out.println(iterator.next().toString());
			}*/


			/*List<Cd> resObj1 = cdDaoObj.getProductList("Rock");
			Iterator<Cd> iterator1 = resObj1.iterator();
			while(iterator1.hasNext())
			{
				System.out.println(iterator1.next().getArtist());
			}*/

			Cd cdObj = cdDaoObj.getProductInfo(1001);
			System.out.println(cdObj.getGenre());




		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}
	}

}
