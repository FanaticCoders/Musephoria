package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.musephoria.entity.*;

/**
 * Home object for domain model class Orderitem.
 * @see com.musephoria.entity.Orderitem
 * @author Hibernate Tools
 */
@Stateless
public class OrderitemHome {

	private static final Log log = LogFactory.getLog(OrderitemHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Orderitem transientInstance) {
		log.debug("persisting Orderitem instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Orderitem persistentInstance) {
		log.debug("removing Orderitem instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Orderitem merge(Orderitem detachedInstance) {
		log.debug("merging Orderitem instance");
		try {
			Orderitem result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Orderitem findById(Integer id) {
		log.debug("getting Orderitem instance with id: " + id);
		try {
			Orderitem instance = entityManager.find(Orderitem.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
