package com.project.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.project.bean.CutPageBean;
import com.project.bean.UserBean;
import com.project.dao.IUserDao;
import com.project.util.BaseDao;

public class UserDaoImpl extends BaseDao implements IUserDao {

	private int PAGESIZE = 3;
	
	@Override
	public void add(UserBean bean) {
		// TODO Auto-generated method stub
		//��ȡ�����ļ�
		//Configuration cfg = new Configuration();��ȡhibernate.properties
		//Configuration cfg = new Configuration().configure; ��ȡhibernate.cfg.xml
		Configuration cfg = new Configuration().configure();
		//����ע�����
		ServiceRegistry r = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		//�����Ự����
		SessionFactory factory = cfg.buildSessionFactory(r);
		//�����Ự��һ���Ự�൱��һ������
		Session session = factory.openSession();
		
		System.out.println(bean);
		
		try {
			//��������
			session.beginTransaction();
			//��Ӷ���
			session.save(bean);
			session.save(new UserBean("mmm",5000,"��",Date.valueOf("1993-02-18"),"ҵ��Ա"));
			
			//�ύ����
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			session.close();
		}

	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		//��ȡ�����ļ�
		Configuration cfg = new Configuration().configure();
		//����ע�����
		ServiceRegistry r = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		//�����Ự����
		SessionFactory factory = cfg.buildSessionFactory(r);
		//�����Ự
		Session session = factory.openSession();
		try {
			//��������
			session.beginTransaction();
			//�õ�ָ��ID����������Ӧ�Ķ���
			UserBean bean = (UserBean)session.get(UserBean.class, id);
			//ɾ������
			session.delete(bean);
			//�ύ����
			session.getTransaction().commit();			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			session.close();
		}

	}

	@Override
	public void update(int id, String job) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		try {
			session.beginTransaction();
			UserBean bean = (UserBean)session.get(UserBean.class, id);
			bean.setJob(job);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally{
			session.close();
		}
	}

	@Override
	public UserBean findById(int id) {
		Session session = this.getSession();
		//ͨ��ID��session�����ѯ����ȡUserBean���͵�����
		UserBean bean = (UserBean)session.get(UserBean.class, id);
		session.close();
		return bean;
	}

	@Override
	public List<UserBean> findAll() {
		Session session = this.getSession();
		//HQL��䣬��ѯ����:�����������ԣ����漰�����
		//from:��������ʾ��ѯ�����Ӧ�ı������м�¼
		Query q = session.createQuery("from UserBean");
		List<UserBean> list = q.list();
		return list;
	}

	@Override
	public List<UserBean> findByName(String name) {
		Session session = this.getSession();
		//����ʾռλ������0��ʼ
		Query q = session.createQuery("from UserBean where name like ?");
		q.setString(0,"%"+name+"%");
		
		List<UserBean> list = q.list();
		session.close();
		return list;
	}

	@Override
	public List<UserBean> findByBirthday(Date startDate, Date endDate) {
		Session session = this.getSession();
		//:start ��ʾ����վλ������������ռλ����������ռλ����ֵ
		Query q = session.createQuery("from UserBean where birthday >= :start and birthday <= :end");
//		q.setDate("start", startDate);
//		q.setDate("end", endDate);

		Map map = new HashMap();
		map.put("start", startDate);
		map.put("end", endDate);
		q.setProperties(map);
		
		List<UserBean> list = q.list();
		session.close();
		return list;
	}

	@Override
	public CutPageBean<UserBean> cutAll(int pageNO) {
		Session session = this.getSession();
		CutPageBean<UserBean> cutBean = new CutPageBean<UserBean>();
		Query q = session.createQuery("from UserBean");
		//������ʼ��¼��
		q.setFirstResult((pageNO - 1) * PAGESIZE);
		//����ÿҳ��ʾ������
		q.setMaxResults(PAGESIZE);
		//��װ��ǰҳ��ʾ������
		cutBean.setList(q.list());
		//ͳ���ܼ�¼��
		Query countQuery = session.createQuery("select count(*) from UserBean");
		//uniqueResult()�õ�Ψһ����ǰ���ǲ�ѯ���Ϊ���е���
		String str = countQuery.uniqueResult().toString();
		cutBean.setCount(Integer.parseInt(str));
		 
		//��ҳ��
		if(cutBean.getCount() % PAGESIZE == 0){
			cutBean.setTotalPage(cutBean.getCount() / PAGESIZE);
		}else{
			cutBean.setTotalPage(cutBean.getCount() / PAGESIZE + 1);
		}
		
		session.close();
		return cutBean;
	}
	
	@Override
	public CutPageBean<UserBean> findByItem(int pageNO, String name, Date startDate, Date endDate) {

		Map map = new HashMap();
		String hql = "from UserBean where 1=1 ";
		if(name != null && name.length() != 0 ){
			hql += " and name like :name ";
			map.put("name", "%"+name+"%");
		}
		if(startDate != null){
			hql += " and birthday >= :start ";
			map.put("start", startDate);
		}
		if(endDate != null){
			hql += "and birthday <= :end ";
			map.put("end", endDate);
		}

		CutPageBean<UserBean> cutBean = new CutPageBean<UserBean>();
		
		Session session = this.getSession();
		Query q = session.createQuery(hql);
		q.setProperties(map);
		q.setFirstResult((pageNO - 1) * PAGESIZE);
		q.setMaxResults(PAGESIZE);
		
		cutBean.setList(q.list());
		//�ܼ�¼��
		Query countQuery = session.createQuery("select count(*) " + hql);
		countQuery.setProperties(map);
		String str = countQuery.uniqueResult().toString();
		cutBean.setCount(Integer.parseInt(str));
		
		//��ҳ��
		if(cutBean.getCount() % PAGESIZE == 0){
			cutBean.setTotalPage(cutBean.getCount() / PAGESIZE );
		}else{
			cutBean.setTotalPage(cutBean.getCount() / PAGESIZE + 1);
		}
		
				
		session.close();
		
		return cutBean;
	}
	
	public static void main(String[] args){
		IUserDao dao = new UserDaoImpl();
		List<UserBean> list = new ArrayList<UserBean>();
		CutPageBean<UserBean> cutPage = new CutPageBean<UserBean>();
//		dao.add(new UserBean("Tim",5000,"��",Date.valueOf("1993-02-18"),"ҵ��Ա"));
//		dao.del(1);		
//		dao.findAll();
//		list = dao.findByName("Tim");
//		list = dao.findByBirthday(Date.valueOf("1990-11-1"), Date.valueOf("1999-11-11"));
//		System.out.println(list);
//		cutPage = dao.cutAll(1);
		cutPage = dao.findByItem(1,"Tim", Date.valueOf("1990-11-1"), Date.valueOf("1999-11-1"));
		
		System.out.println(cutPage);
	}



}
