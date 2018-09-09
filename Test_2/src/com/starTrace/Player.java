package com.starTrace;
// 子类：Player 玩家，继承父类 People 人，实现接口 Play 
public class Player extends People implements Play{

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		System.out.println("玩家正在玩儿游戏！");
	}

	@Override
	public void stopGame() {
		// TODO Auto-generated method stub
		System.out.println("玩家停止了游戏！");
	}

	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("玩家在休息！");
	}
}
