package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Customerdetail;
import com.musephoria.entity.Result;
import com.musephoria.util.Constants;

/**
 * Home object for domain model class Customerdetail.
 *
 * @see com.musephoria.entity.Customerdetail
 * @author Hibernate Tools
 */
@Stateless
public class CustomerdetailHome implements ICustomerdetailHome {

	DBManager dbManager;

	/**
	 * Initialises the DBManager.
	 */
	public CustomerdetailHome() {
		dbManager = new DBManager();
	}

	/* (non-Javadoc)
	 * @see com.musephoria.dao.ICustomerdetailHome#saveCustomerDetails(com.musephoria.entity.Customerdetail)
	 */
	@Override
	public Result saveCustomerDetails(Customerdetail customerdetail) {
		Result resObj = null;
		if (!customerdetail.equals(null)) {
			List<Customerdetail> customerdetailList = new ArrayList<Customerdetail>();
			customerdetailList.add(customerdetail);
			resObj = dbManager.SaveNewData(customerdetailList);
		}
		dbManager.CleanUpSession();
		return resObj;
	}


	/* (non-Javadoc)
	 * @see com.musephoria.dao.ICustomerdetailHome#getCustomerDetails(int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Customerdetail getCustomerDetails(int customerId) {

		Customerdetail customerDetail = null;
		if (customerId > 0) {
			List<Integer> custIdList = new ArrayList<Integer>();
			custIdList.add(customerId);

			Result resObj = dbManager.GetQueryResult(Constants.getCustomerDetails, custIdList);
			if (!resObj.equals(null)) {
				if (!resObj.getResultList().isEmpty()) {
					Iterator<Customerdetail> temp = (Iterator<Customerdetail>) resObj.getResultList().iterator();
					if(temp.hasNext()) {
						customerDetail = temp.next();
					}
				}

			}

			return customerDetail;
		}

		return customerDetail;
	}

}
