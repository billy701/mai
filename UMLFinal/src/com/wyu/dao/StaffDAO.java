package com.wyu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wyu.mapping.Record;
import com.wyu.mapping.Staff;

public class StaffDAO {
	public static Staff getById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Staff user = (Staff) session.get(Staff.class, id);
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
			Staff user = StaffDAO.getById(id);
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
	
	public static void update(Staff user){
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
	
	public static void save(Staff user){
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
	
	public static List<Staff> findAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
					
			List list =  session.createQuery("FROM Staff").list();			
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
