package com.starTrace;

public class Test {
	public static void main(String [] arg){
		// 父类 People：子类 Player 向上转型，只能调用继承或者重写父类的方法。	
		People people = new Player();
		people.breathe();
		// 接口 Play： 通过 Player 完成实例，可以调用子类重写的方法。
		Play play = new Player();
		play.playGame();
		play.stopGame();
		// 子类可以调用从父类继承的方法，实现接口重写的方法，还有自身独有的方法。
		Player p = new Player();
		p.breathe();
		p.playGame();
		p.stopGame();
		p.sleep();
		// 通过多态应用，向上转型，传入不同对象参数。
		Game g = new Game();
		g.start(play);
		g.start(p);
	}
}
