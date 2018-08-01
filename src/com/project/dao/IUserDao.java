package com.project.dao;

import java.sql.Date;
import java.util.List;

import com.project.bean.CutPageBean;
import com.project.bean.UserBean;

/**
 * �û��־ýӿ�
 * @author lenovo
 *
 */
public interface IUserDao {
		
	/**
	 * ���
	 * @param bean
	 */
	public void add(UserBean bean);
	/**
	 * ɾ��
	 * @param id
	 */
	public void del(int id);
	/**
	 * ���û�ID������ְλ
	 * @param id
	 * @param job
	 */
	public void update(int id,String job);
	/**
	 * ����ID��ѯ
	 * @param id
	 * @return �û�����
	 */
	public UserBean findById(int id);
	/**
	 * ��ѯ�����û�
	 * @return �û����󼯺�
	*/ 
	public List<UserBean> findAll();
	/**
	 * �������ֲ�ѯ
	 * @return UserBean����
	 */
	public List<UserBean> findByName(String name);
	/**
	 * �������ղ�ѯ
	 * @param startDate
	 * @param endDate
	 * @return UserBean����
	 */
	public List<UserBean> findByBirthday(Date startDate,Date endDate);
	/**
	 * ��ѯ���еķ�ҳ
	 * @param pageNO ҳ��
	 * @return CutPageBean ��ҳ����
	 */
	public CutPageBean<UserBean> cutAll(int pageNO);
	/**
	 * ��̬������ҳ��ѯ
	 * @param pageNO ҳ��
	 * @param name ����
	 * @param startDate ��ʼʱ��
	 * @param endDate ����ʱ��
	 * @return ��ҳ����
	 */
	public CutPageBean<UserBean> findByItem(int pageNO,String name,
			Date startDate, Date endDate);
}
