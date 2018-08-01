package com.project.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class BaseDao {

	/**�Ự����*/
	private static SessionFactory factory;
	static{
		//��ȡ�����ļ�
		Configuration cfg = new Configuration().configure();
		//����ע�����
		ServiceRegistry r = new ServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).buildServiceRegistry();
		//�����Ự����
		factory = cfg.buildSessionFactory(r);	
	}
	
	public Session getSession(){
		//�����Ự��һ���Ự�൱��һ������
		return factory.openSession();
	}
	
}
