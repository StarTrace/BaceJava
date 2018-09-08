package com.starTrace;

public class Outer_1 {
	static int a = 10;
	static void f(){
		System.out.println("外部静态方法：a = " + a);
	}
	/*
	 * 静态内部类：可以直接导入类，再进行实例化
	 */
	static class Inner{
		public void g(){
			f();
		}
	}
}
