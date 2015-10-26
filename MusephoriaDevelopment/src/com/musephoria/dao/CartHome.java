package com.musephoria.dao;
// Generated Oct 19, 2015 11:46:20 PM by Hibernate Tools 4.3.1.Final

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.musephoria.dbmanager.DBManager;
import com.musephoria.entity.*;


/**
 * Home object for domain model class Cart.
 * @see com.musephoria.entity.Cart
 * @author Hibernate Tools
 */
@Stateless
public class CartHome {
	
	DBManager dbManager;
	
	public CartHome(){
		dbManager = new DBManager();
	}

	private static final Log log = LogFactory.getLog(CartHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Cart transientInstance) {
		log.debug("persisting Cart instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Cart persistentInstance) {
		log.debug("removing Cart instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Cart merge(Cart detachedInstance) {
		log.debug("merging Cart instance");
		try {
			Cart result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cart findById(Integer id) {
		log.debug("getting Cart instance with id: " + id);
		try {
			Cart instance = entityManager.find(Cart.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public boolean insertToCart(Cart cartinfo){
		Result resobj = null;
		boolean flag = false;
		try{
			List<Object> datalist = new ArrayList<Object>();
			datalist.add(cartinfo);
			
			//Inserting the cart information to the database
			if(!datalist.isEmpty()){
				resobj = dbManager.saveOrUpdateData(datalist); 
			}
			
			//Checking if the data is inserted and setting flag accordingly
			if(resobj.getResultCount() > 0){
				flag = true;
			}
			
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}	
		
	
		
}
