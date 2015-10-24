package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.musephoria.entity.*;

/**
 * Home object for domain model class Shipping.
 * @see com.musephoria.entity.Shipping
 * @author Hibernate Tools
 */
@Stateless
public class ShippingHome {

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
}