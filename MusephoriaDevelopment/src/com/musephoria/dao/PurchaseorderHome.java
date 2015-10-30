package com.musephoria.dao;
// default package

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Generated Oct 29, 2015 12:25:06 AM by Hibernate Tools 4.0.0.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.Cd;
import com.musephoria.entity.Purchaseorder;
import com.musephoria.entity.Purchaseorderitem;
import com.musephoria.entity.Shipping;
import com.musephoria.shoppingcart.ShoppingCart;

/**
 * Home object for domain model class Purchaseorder.
 * 
 * @see .Purchaseorder
 * @author Hibernate Tools
 */
@Stateless
public class PurchaseorderHome {

	private static final Log log = LogFactory.getLog(PurchaseorderHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Purchaseorder transientInstance) {
		log.debug("persisting Purchaseorder instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Purchaseorder persistentInstance) {
		log.debug("removing Purchaseorder instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Purchaseorder merge(Purchaseorder detachedInstance) {
		log.debug("merging Purchaseorder instance");
		try {
			Purchaseorder result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Purchaseorder findById(Integer id) {
		log.debug("getting Purchaseorder instance with id: " + id);
		try {
			Purchaseorder instance = entityManager.find(Purchaseorder.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public boolean createOrder(ShoppingCart shoppingCartInfo, Shipping shippingInfo) {

		boolean isOrderCreated = false;
		
		List<Purchaseorderitem> poItem = new ArrayList<Purchaseorderitem>();		
		List<Purchaseorder> poList = new ArrayList<Purchaseorder>();
		
		DBManager dbManager = new DBManager();
		

		if (shoppingCartInfo != null && shippingInfo != null) {
			
			
			List<Cd> cdList = new ArrayList<Cd>();
			cdList.add((Cd) shoppingCartInfo.getCdList());
			Iterator<Cd> looper = cdList.iterator();
			while(looper.hasNext()){
	
			}
			
			//poItem.add(shoppingCartInfo.g)
			
		
			
		}
		
		return isOrderCreated;	
	}

}
