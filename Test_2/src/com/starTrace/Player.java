package com.starTrace;
// ���ࣺPlayer ��ң��̳и��� People �ˣ�ʵ�ֽӿ� Play 
public class Player extends People implements Play{

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		System.out.println("������������Ϸ��");
	}

	@Override
	public void stopGame() {
		// TODO Auto-generated method stub
		System.out.println("���ֹͣ����Ϸ��");
	}

	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("�������Ϣ��");
	}
}
