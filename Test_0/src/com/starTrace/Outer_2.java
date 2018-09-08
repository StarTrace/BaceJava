package com.starTrace;

public class Outer_2 {
	int a = 5;
	static int b = 10;
	void f(){
		System.out.println("外部方法");
	}
	
	class Inner{
		void g(){
			b = 100;
			f();
			System.out.println("a = " + a);
			System.out.println("b = " + b);
		}
	}
}
