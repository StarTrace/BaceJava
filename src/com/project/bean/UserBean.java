package com.project.bean;

import java.sql.Date;

public class UserBean {
	/**id*/
	private int id;
	/**姓名*/
	private String name;
	/**工资*/
	private int money;
	/**性别*/
	private String sex;
	/**生日*/
	private Date birthday;
	/**职位*/
	private String job;
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserBean(String name, int money, String sex, Date birthday, String job) {
		super();
		this.name = name;
		this.money = money;
		this.sex = sex;
		this.birthday = birthday;
		this.job = job;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", money=" + money + ", sex=" + sex + ", birthday=" + birthday
				+ ", job=" + job + "]";
	}
	

}
