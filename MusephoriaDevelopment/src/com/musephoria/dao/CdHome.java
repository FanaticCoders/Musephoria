package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Cd;
import com.musephoria.entity.Result;
import com.musephoria.util.Constants;

/**
 * Home object for domain model class Cd.
 *
 * @see com.musephoria.entity.Cd
 * @author Hibernate Tools
 */
@Stateless
public class CdHome {

	DBManager dbManager;
	private static final Log log = LogFactory.getLog(CdHome.class);

	/**
	 * Initialises the DBManager.
	 */
	public CdHome() {
		dbManager = new DBManager();
	}

	/**
	 * Gets the category list from the database.
	 *
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public List<String> getCategoryList() {
		Result resObj = null;
		List<String> categoryList = null;

		try {
			resObj = dbManager.getQueryResult(Constants.getCategoryList, null);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}

		if (!resObj.equals(null)) {
			categoryList = (List<String>) resObj.getResultList();
		}

		dbManager.cleanUpSession();
		return categoryList;
	}

	/**
	 * Gets the product list based on category id.
	 *
	 * @param categoryId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Cd> getProductList(String categoryId) {
		Result resObj = null;
		List<Cd> productlist = null;

		// Adding the category id to the list.
		List<String> parameterList = new ArrayList<String>();
		if (!categoryId.isEmpty()) {
			parameterList.add(categoryId);
		}

		try {
			if (!parameterList.isEmpty()) {
				// Get product list with category specified.
				resObj = dbManager.getQueryResult(Constants.getProductListWithCategory, parameterList);
			} else {
				// Get product list with no category specified.
				resObj = dbManager.getQueryResult(Constants.getProductList, null);
			}

		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}

		if (!resObj.equals(null)) {
			productlist = (List<Cd>) resObj.getResultList();
		}

		dbManager.cleanUpSession();
		return productlist;
	}

	/**
	 * Ger Product Info based on the product id.
	 * @param productid
	 * @return
	 */
	public Cd getProductInfo(int productid) {
		Result resObj = null;
		Cd productInfo = new Cd();

		List<Integer> parameterList = new ArrayList<Integer>();
		if (productid != 0) {
			parameterList.add(productid);

			try {
				resObj = dbManager.getQueryResult(Constants.getProductInfo, parameterList);
			} catch (Exception e) {
				log.error(e.getLocalizedMessage(), e);
			}

			if (!resObj.equals(null) && !resObj.getResultList().isEmpty()) {
				productInfo = (Cd) resObj.getResultList().get(0);
			}
		}
		dbManager.cleanUpSession();
		return productInfo;
	}
}
