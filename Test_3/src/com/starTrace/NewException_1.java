package com.starTrace;
// �Զ���һ���쳣
@SuppressWarnings("serial")
public class NewException_1 extends Exception {
	private String message;
	//���������붨����쳣��Ϣ
	public NewException_1(String message){
		this.message = "����� �쳣: " + message;
	}
	// �����쳣��Ϣ
	public String getMessage(){
		return message;
	}
	
}
