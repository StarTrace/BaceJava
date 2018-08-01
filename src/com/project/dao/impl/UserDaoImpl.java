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
		//读取配置文件
		//Configuration cfg = new Configuration();读取hibernate.properties
		//Configuration cfg = new Configuration().configure; 读取hibernate.cfg.xml
		Configuration cfg = new Configuration().configure();
		//创建注册对象
		ServiceRegistry r = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		//创建会话工厂
		SessionFactory factory = cfg.buildSessionFactory(r);
		//创建会话，一个会话相当于一个连接
		Session session = factory.openSession();
		
		System.out.println(bean);
		
		try {
			//开启事务
			session.beginTransaction();
			//添加对象
			session.save(bean);
			session.save(new UserBean("mmm",5000,"男",Date.valueOf("1993-02-18"),"业务员"));
			
			//提交事务
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
		//读取配置文件
		Configuration cfg = new Configuration().configure();
		//创建注册对象
		ServiceRegistry r = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		//创建会话工厂
		SessionFactory factory = cfg.buildSessionFactory(r);
		//创建会话
		Session session = factory.openSession();
		try {
			//开启事务
			session.beginTransaction();
			//得到指定ID（主键）对应的对象
			UserBean bean = (UserBean)session.get(UserBean.class, id);
			//删除对象
			session.delete(bean);
			//提交事务
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
		//通过ID，session事务查询，获取UserBean类型的数据
		UserBean bean = (UserBean)session.get(UserBean.class, id);
		session.close();
		return bean;
	}

	@Override
	public List<UserBean> findAll() {
		Session session = this.getSession();
		//HQL语句，查询数据:面向对象和属性，不涉及表和列
		//from:类名，表示查询该类对应的表中所有记录
		Query q = session.createQuery("from UserBean");
		List<UserBean> list = q.list();
		return list;
	}

	@Override
	public List<UserBean> findByName(String name) {
		Session session = this.getSession();
		//？表示占位符，从0开始
		Query q = session.createQuery("from UserBean where name like ?");
		q.setString(0,"%"+name+"%");
		
		List<UserBean> list = q.list();
		session.close();
		return list;
	}

	@Override
	public List<UserBean> findByBirthday(Date startDate, Date endDate) {
		Session session = this.getSession();
		//:start 表示符号站位符，可以利用占位符名称设置占位符的值
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
		//设置起始记录数
		q.setFirstResult((pageNO - 1) * PAGESIZE);
		//设置每页显示的数据
		q.setMaxResults(PAGESIZE);
		//封装当前页显示的数据
		cutBean.setList(q.list());
		//统计总记录数
		Query countQuery = session.createQuery("select count(*) from UserBean");
		//uniqueResult()得到唯一对象，前提是查询结果为单行单列
		String str = countQuery.uniqueResult().toString();
		cutBean.setCount(Integer.parseInt(str));
		 
		//总页数
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
		//总记录数
		Query countQuery = session.createQuery("select count(*) " + hql);
		countQuery.setProperties(map);
		String str = countQuery.uniqueResult().toString();
		cutBean.setCount(Integer.parseInt(str));
		
		//总页数
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
//		dao.add(new UserBean("Tim",5000,"男",Date.valueOf("1993-02-18"),"业务员"));
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
