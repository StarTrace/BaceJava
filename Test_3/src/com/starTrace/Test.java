package com.starTrace;

public class Test {
	public static void main(String [] args){
		// 多个 try-catch，当一个catch捕获异常，之后的catch 不再执行。
//		try{
//			int num = 3/0;
//		}catch( ArithmeticException e1){
//			System.out.println("算数错误：");	
//		}catch(Exception e2){
//			System.out.println("有错误");
//		}finally{
//			System.out.println("over");
//		}
		
		// 异常处理：自定义异常，抛出异常，捕获异常，获取异常信息
		Util u = new Util();
		try {
			u.test();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 自定义异常：定义异常，抛出异常，捕捉异常，处理异常
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
