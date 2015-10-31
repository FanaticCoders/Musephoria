package com.musephoria.dao;
// default package
// Generated Oct 29, 2015 12:25:06 AM by Hibernate Tools 4.0.0.Final

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Purchaseorderitem;
import com.musephoria.entity.Result;
import com.musephoria.entity.Shipping;
import com.musephoria.shoppingcart.ShoppingCart;

/**
 * Home object for domain model class Shipping.
 * @see .Shipping
 * @author Hibernate Tools
 */
@Stateless
public class ShippingHome {

	DBManager dbManager;
	private static final Log log = LogFactory.getLog(ShippingHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Shipping transientInstance) {
		log.debug("persisting Shipping instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Shipping persistentInstance) {
		log.debug("removing Shipping instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Shipping merge(Shipping detachedInstance) {
		log.debug("merging Shipping instance");
		try {
			Shipping result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Shipping findById(Integer id) {
		log.debug("getting Shipping instance with id: " + id);
		try {
			Shipping instance = entityManager.find(Shipping.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Result shippingInfo(int purchaseOrderId ,Shipping shippingInfo) {
		List<Shipping> shipping= new ArrayList<Shipping>();
		Result shipResObj = null;
		try{
		if(!shippingInfo.equals(null))
		{
			// Setting the PO Object with PO ID.
			Purchaseorder purchaseOrderObj = new Purchaseorder();
			purchaseOrderObj.setPurchaseOrderId(purchaseOrderId);
			// Setting PO Id in shippingInfo
			shippingInfo.setPurchaseorder(purchaseOrderObj);			
			shipResObj = dbManager.saveNewData(shipping);
		}
	
		
		dbManager.cleanUpSession();
	}
		catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}
		
	    return shipResObj;
	}
}