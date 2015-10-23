package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.musephoria.entity.*;

/**
 * Home object for domain model class Track.
 * @see com.musephoria.entity.Track
 * @author Hibernate Tools
 */
@Stateless
public class TrackHome {

	private static final Log log = LogFactory.getLog(TrackHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Track transientInstance) {
		log.debug("persisting Track instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Track persistentInstance) {
		log.debug("removing Track instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Track merge(Track detachedInstance) {
		log.debug("merging Track instance");
		try {
			Track result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Track findById(Integer id) {
		log.debug("getting Track instance with id: " + id);
		try {
			Track instance = entityManager.find(Track.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
