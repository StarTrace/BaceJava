package com.starTrace;

public class Test {
	public static void main(String [] arg){
		// ���� People������ Player ����ת�ͣ�ֻ�ܵ��ü̳л�����д����ķ�����	
		People people = new Player();
		people.breathe();
		// �ӿ� Play�� ͨ�� Player ���ʵ�������Ե���������д�ķ�����
		Play play = new Player();
		play.playGame();
		play.stopGame();
		// ������Ե��ôӸ���̳еķ�����ʵ�ֽӿ���д�ķ���������������еķ�����
		Player p = new Player();
		p.breathe();
		p.playGame();
		p.stopGame();
		p.sleep();
		// ͨ����̬Ӧ�ã�����ת�ͣ����벻ͬ���������
		Game g = new Game();
		g.start(play);
		g.start(p);
	}
}
