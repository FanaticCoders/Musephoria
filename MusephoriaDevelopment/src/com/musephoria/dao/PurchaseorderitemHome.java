package com.musephoria.dao;
// default package
// Generated Oct 29, 2015 12:25:06 AM by Hibernate Tools 4.0.0.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.entity.Purchaseorderitem;

/**
 * Home object for domain model class Purchaseorderitem.
 * @see .Purchaseorderitem
 * @author Hibernate Tools
 */
@Stateless
public class PurchaseorderitemHome {

	private static final Log log = LogFactory.getLog(PurchaseorderitemHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Purchaseorderitem transientInstance) {
		log.debug("persisting Purchaseorderitem instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Purchaseorderitem persistentInstance) {
		log.debug("removing Purchaseorderitem instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Purchaseorderitem merge(Purchaseorderitem detachedInstance) {
		log.debug("merging Purchaseorderitem instance");
		try {
			Purchaseorderitem result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Purchaseorderitem findById(Integer id) {
		log.debug("getting Purchaseorderitem instance with id: " + id);
		try {
			Purchaseorderitem instance = entityManager.find(Purchaseorderitem.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
