package com.wyu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wyu.mapping.CheckIn;
import com.wyu.mapping.Record;

public class RecordDAO{
	public static Record getById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Record user = (Record) session.get(Record.class, id);
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
			Record user = RecordDAO.getById(id);
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
	
	public static void update(Record user){
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
	
	public static void save(Record user){
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
	
	public static List<Record> findAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
					
			List list =  session.createQuery("FROM Record").list();			
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
