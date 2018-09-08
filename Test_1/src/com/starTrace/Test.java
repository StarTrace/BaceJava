package com.starTrace;

public class Test {

	public static void main(String [] args){
		Pet p = new Cat();	//向上转型：Cat 转型为 Pet,是 Pet,也是Cat
		Pet d = new Dog();	//向上转型：Dog 转型为 Pet,是 Pet,也是Dog
		p.eat();	// 向上转型只能访问父类有，子类重写的方法。	
		d.eat();
		// 确认要转型的类符合类型，才能向下转型，否则一定会报错。
		// P 属于 Cat 类型则满足条件
		if(p instanceof Cat){
			System.out.print("p 属于 Cat 类型：");
			Cat c = (Cat)p;		//Cat 类型的 Pet,可以向下转型为 Cat
			c.eat();
		}
		
		Master m = new Master();
		// 使用向上转型，实现多态
		m.feeding(new Pet());
		m.feeding(new Dog());
		m.feeding(new Cat());		
	}
}

