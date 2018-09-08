package com.starTrace;

public class Outer_3 {
	int a = 5;
	void f(){
		// 局部变量必须声明为final。如果不声明，在不改变值的情况也是默认为final，否则会造成编译错误。
		// 编译后局部内部和外部类分别产生一个class文件，调用的局部变量改变就会出错，所以定义为final。
		final int b = 15;  
		System.out.println("进入方法 f:");
		class Inner{
			int c = 20;
			void g(){
				c = b + 10; // 局部变量值可以使用，但不能改变值。
				System.out.println("a = " + a);
				System.out.println("b = " + b);
				System.out.println("c = " + c);
			}
		}
		Inner in = new Inner();
		in.g();
	}
}
