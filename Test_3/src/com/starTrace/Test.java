package com.starTrace;

public class Test {
	public static void main(String [] args){
		// ��� try-catch����һ��catch�����쳣��֮���catch ����ִ�С�
//		try{
//			int num = 3/0;
//		}catch( ArithmeticException e1){
//			System.out.println("��������");	
//		}catch(Exception e2){
//			System.out.println("�д���");
//		}finally{
//			System.out.println("over");
//		}
		
		// �쳣�����Զ����쳣���׳��쳣�������쳣����ȡ�쳣��Ϣ
		Util u = new Util();
		try {
			u.test();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// �Զ����쳣�������쳣���׳��쳣����׽�쳣�������쳣
		int i = 10;
		try {
			if(i == 10){
				throw new NewException_1("exception: i = 10");
			}
		} catch (NewException_1 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
