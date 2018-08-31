package com.starTrace;

public class Student extends People{
	int age;
	String name;
	public Student(){	
		System.out.println("调用无参构造 A:");		
	};	
	public Student(String name){	
		this(22, name);	// 调用有参构造函数
		System.out.println("调用有参构造 B： name = " + name + ", Age = " + age);
	};	
	
	public Student(int age,String name){
		this(); // 调用无参构造函数
		this.age = age;
		System.out.println("调用有参构造 C： name = " + name + ", Age = " + age);
	}
	
	public void showData(){
		
	}
}
