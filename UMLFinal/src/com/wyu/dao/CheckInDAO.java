package com.wyu.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wyu.mapping.CheckIn;

/**
 * A data access object (DAO) providing persistence and search support for
 * CheckIn entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wyu.mapping.CheckIn
 * @author MyEclipse Persistence Tools
 */
public class CheckInDAO {
	public static CheckIn getById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			CheckIn user = (CheckIn) session.get(CheckIn.class, id);
			tx.commit();
			
			return user;
		}catch(RuntimeException e){
			tx.rollback();//事务回滚
			throw e;
		}
		finally{
			session.close();
		}
	}
	
	public static void delete(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			CheckIn user = CheckInDAO.getById(id);
			session.delete(user);
			tx.commit();
		}catch(RuntimeException e){
			tx.rollback();//事务回滚
			throw e;
		}
		finally{
			session.close();
		}
		
		
	}
	
	public static void update(CheckIn user){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		}catch(RuntimeException e){
			tx.rollback();//事务回滚
			throw e;
		}
		finally{
			session.close();
		}
	}
	
	public static void save(CheckIn user){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch(RuntimeException e){
			tx.rollback();//事务回滚
			throw e;
		}
		finally{
			session.close();
		}
	}
	
	public static List<CheckIn> findAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
					
			List list =  session.createQuery("FROM CheckIn").list();			
			tx.commit();
			
			return list;
		}catch(RuntimeException e){
			tx.rollback();//事务回滚
			throw e;
		}
		finally{
			session.close();
		}
		
		
	}
}