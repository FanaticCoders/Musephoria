package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

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
	public Result GetCategoryList() {
		Result resObj = dbManager.GetQueryResult(Constants.getCategoryList, null);
		return resObj;
	}
}
