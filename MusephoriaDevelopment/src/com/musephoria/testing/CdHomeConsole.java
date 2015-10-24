/**
 *
 */
package com.musephoria.testing;

import java.util.List;
import java.util.ListIterator;

import org.apache.commons.lang3.StringUtils;

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

			
			Result resObj = cdDaoObj.getProductList("Rock");
			
			List<Cd> temp = (List<Cd>) resObj.getResultList();
			ListIterator<Cd> temp1 = temp.listIterator();

			while(temp1.hasNext()){
				System.out.println(temp1.next().getCdId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
		}
	}

}
