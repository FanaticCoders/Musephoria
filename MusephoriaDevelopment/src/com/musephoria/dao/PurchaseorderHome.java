package com.musephoria.dao;
// default package
// Generated Oct 24, 2015 11:30:12 PM by Hibernate Tools 4.0.0.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.entity.Purchaseorder;

/**
 * Home object for domain model class Purchaseorder.
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
}
