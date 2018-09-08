package com.starTrace;

//import com.starTrace.Outer_2.Inner; //2.导入成员内部类

//import com.starTrace.Outer_1.Inner; // 1.静态内部类直接导入,不需要实例化外部类

public class Test {

	public static void main(String [] args){
		//1.静态内部类
//		Inner in = new Inner();
//		in.g();
		
		//2.成员内部类:必须先实例化外部类
//		Outer_2 out = new Outer_2();
//		Inner in = out.new Inner();
//		in.g();
//		System.out.println("b = " + Outer_2.b);
		
		//3.局部内部类
//		Outer_3 out = new Outer_3();
//		out.f();

		//4. 匿名内部类
		Outer_4 out = new Outer_4();
		out.show(new Inner(){
			public void show() {
				System.out.println("匿名内部类");
			}
			public void see(){
				System.out.println("匿名内部类");
			}
		});
		
	}

}

