package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Result;
import com.musephoria.util.Constants;

/**
 * Home object for domain model class Cd.
 *
 * @see com.musephoria.entity.Cd
 * @author Hibernate Tools
 */
@Stateless
public class CdHome implements ICdHome {

	DBManager dbManager;

	/**
	 * Initialises the DBManager.
	 */
	public CdHome() {
		dbManager = new DBManager();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.musephoria.dao.ICdHome#GetCategoryList()
	 */
	@Override
	public Result GetCategoryList() {
		Result resObj = dbManager.getQueryResult(Constants.getCategoryList, null);
		return resObj;
	}

	@Override
	public Result getProductList(String genre) {
		Result resObj = null;
		try {
			List<String> parameterList = new ArrayList<String>();
			if (!genre.isEmpty()) {
				parameterList.add(genre);
			}
			System.out.print(parameterList);
			if (!parameterList.isEmpty()) {
				resObj = dbManager.getQueryResult(Constants.getProductListWithCategory, parameterList);
			} else {
				resObj = dbManager.getQueryResult(Constants.getProductList, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		dbManager.cleanUpSession();
		return resObj;
	}

	@Override
	public Result getProductInfo(int Cdid) {

		Result resObj = null;
		try {
			List<Integer> parameterList = new ArrayList<Integer>();
			if (Cdid != 0) {
				parameterList.add(Cdid);
			}
			if (!parameterList.isEmpty()) {
				resObj = dbManager.getQueryResult(Constants.getProductInfo, parameterList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbManager.cleanUpSession();
		return resObj;

	}

}
