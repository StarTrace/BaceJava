package com.starTrace;

public class Master {
	public Master(){
		System.out.println("now: 主人回来了！");
		
	}
	
	public void feeding(Pet p){
//		System.out.println("准备给宠物喂食了！");
		p.eat();
	}
}
