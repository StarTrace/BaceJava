package com.starTrace;
// 自定义一个异常
@SuppressWarnings("serial")
public class NewException_1 extends Exception {
	private String message;
	//构造器传入定义的异常信息
	public NewException_1(String message){
		this.message = "定义的 异常: " + message;
	}
	// 返回异常信息
	public String getMessage(){
		return message;
	}
	
}
