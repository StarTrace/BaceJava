package com.starTrace;

public class Util {
	public static void test() throws Exception{
		int num = 10;
		// �׳��쳣���� num = 10 ʱ���׳��쳣���쳣��ϢΪ�����쳣ֵ10��	
		if(num == 10){	
			throw new Exception("�쳣ֵ 10");
		}
	}
}
