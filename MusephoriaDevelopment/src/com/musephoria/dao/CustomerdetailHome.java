package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.musephoria.entity.*;

/**
 * Home object for domain model class Customerdetail.
 * @see com.musephoria.entity.Customerdetail
 * @author Hibernate Tools
 */
@Stateless
public class CustomerdetailHome {

	private static final Log log = LogFactory.getLog(CustomerdetailHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Customerdetail transientInstance) {
		log.debug("persisting Customerdetail instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Customerdetail persistentInstance) {
		log.debug("removing Customerdetail instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Customerdetail merge(Customerdetail detachedInstance) {
		log.debug("merging Customerdetail instance");
		try {
			Customerdetail result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Customerdetail findById(int id) {
		log.debug("getting Customerdetail instance with id: " + id);
		try {
			Customerdetail instance = entityManager.find(Customerdetail.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
