package com.musephoria.dao;
// default package
// Generated Oct 29, 2015 12:25:06 AM by Hibernate Tools 4.0.0.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.entity.Paymentinfo;

/**
 * Home object for domain model class Paymentinfo.
 * @see .Paymentinfo
 * @author Hibernate Tools
 */
@Stateless
public class PaymentinfoHome {

	private static final Log log = LogFactory.getLog(PaymentinfoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Paymentinfo transientInstance) {
		log.debug("persisting Paymentinfo instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Paymentinfo persistentInstance) {
		log.debug("removing Paymentinfo instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Paymentinfo merge(Paymentinfo detachedInstance) {
		log.debug("merging Paymentinfo instance");
		try {
			Paymentinfo result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Paymentinfo findById(Integer id) {
		log.debug("getting Paymentinfo instance with id: " + id);
		try {
			Paymentinfo instance = entityManager.find(Paymentinfo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
