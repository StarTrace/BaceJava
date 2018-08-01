package com.project.dao;

import java.sql.Date;
import java.util.List;

import com.project.bean.CutPageBean;
import com.project.bean.UserBean;

/**
 * 用户持久接口
 * @author lenovo
 *
 */
public interface IUserDao {
		
	/**
	 * 添加
	 * @param bean
	 */
	public void add(UserBean bean);
	/**
	 * 删除
	 * @param id
	 */
	public void del(int id);
	/**
	 * 按用户ID，更换职位
	 * @param id
	 * @param job
	 */
	public void update(int id,String job);
	/**
	 * 按照ID查询
	 * @param id
	 * @return 用户对象
	 */
	public UserBean findById(int id);
	/**
	 * 查询所有用户
	 * @return 用户对象集合
	*/ 
	public List<UserBean> findAll();
	/**
	 * 按照名字查询
	 * @return UserBean集合
	 */
	public List<UserBean> findByName(String name);
	/**
	 * 按照生日查询
	 * @param startDate
	 * @param endDate
	 * @return UserBean集合
	 */
	public List<UserBean> findByBirthday(Date startDate,Date endDate);
	/**
	 * 查询所有的分页
	 * @param pageNO 页码
	 * @return CutPageBean 分页对象
	 */
	public CutPageBean<UserBean> cutAll(int pageNO);
	/**
	 * 动态条件分页查询
	 * @param pageNO 页码
	 * @param name 姓名
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @return 分页对象
	 */
	public CutPageBean<UserBean> findByItem(int pageNO,String name,
			Date startDate, Date endDate);
}
