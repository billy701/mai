package com.wyu.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration()//
				.configure()// 读取默认位置的配置文件
				.buildSessionFactory();// 生成Session文件
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
