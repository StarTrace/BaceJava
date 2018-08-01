package com.project.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class BaseDao {

	/**会话工厂*/
	private static SessionFactory factory;
	static{
		//读取配置文件
		Configuration cfg = new Configuration().configure();
		//创建注册对象
		ServiceRegistry r = new ServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).buildServiceRegistry();
		//创建会话工厂
		factory = cfg.buildSessionFactory(r);	
	}
	
	public Session getSession(){
		//创建会话，一个会话相当于一个连接
		return factory.openSession();
	}
	
}
