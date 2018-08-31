package com.starTrace;

public class People {
	String name ;

	public People() {
		System.out.println("父类");
	}

	public People(String name) {
		super();
		this.name = name;
		System.out.println("父类：name = " + name);
	}
}
