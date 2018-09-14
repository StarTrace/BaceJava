package com.starTrace;

public class Util {
	public static void test() throws Exception{
		int num = 10;
		// 抛出异常：当 num = 10 时，抛出异常，异常信息为：“异常值10”	
		if(num == 10){	
			throw new Exception("异常值 10");
		}
	}
}
