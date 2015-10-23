package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.musephoria.entity.*;

/**
 * Home object for domain model class Cartitem.
 * @see com.musephoria.entity.Cartitem
 * @author Hibernate Tools
 */
@Stateless
public class CartitemHome {

	private static final Log log = LogFactory.getLog(CartitemHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Cartitem transientInstance) {
		log.debug("persisting Cartitem instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Cartitem persistentInstance) {
		log.debug("removing Cartitem instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Cartitem merge(Cartitem detachedInstance) {
		log.debug("merging Cartitem instance");
		try {
			Cartitem result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cartitem findById(Integer id) {
		log.debug("getting Cartitem instance with id: " + id);
		try {
			Cartitem instance = entityManager.find(Cartitem.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
