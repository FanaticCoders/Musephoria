/**
 *
 */
package com.musephoria.testing;

import java.util.List;
import java.util.ListIterator;

import com.musephoria.dao.CdHome;
import com.musephoria.dao.ICdHome;
import com.musephoria.entity.Cd;
import com.musephoria.entity.Result;

/**
 * @author Admin
 *
 */
public class CdHomeConsole {
	/**
	 * @param args
	 */

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try {

			ICdHome cdDaoObj = new CdHome();
			Result resObj = cdDaoObj.getProductInfo(1001);

			List<Cd> temp = (List<Cd>) resObj.getResultList();
			
			for(Cd c: temp)			
			{
				System.out.println(c.getPrice());
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}
	}

}
