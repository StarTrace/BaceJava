package com.starTrace;
// 游戏，放置一个多态方法
public class Game {
	// 传入一个多态参数：接口 Play,其实现类 Player 可以通过向上转型作为参数，调用方法。
	public void start(Play p){
		p.playGame();
		p.stopGame();
	}
}
