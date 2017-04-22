package com.mkyong.learn.ignore;

public class JUnitMessage {
	private String message;

	public JUnitMessage(String message) {
		this.message = message;
	}

	public String printMessage() {
		System.out.println(message);
		return message;
	}

	public String printHiMessage() {
		message = "Hi!" + message;
		System.out.println(message);
		return message;
	}

}