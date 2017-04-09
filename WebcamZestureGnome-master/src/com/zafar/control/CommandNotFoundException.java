package com.zafar.control;

public class CommandNotFoundException extends Exception {
	String message="Command not found in dictionary!";

	public String toString()
	{
		return message;
	}
	public String getMessage() {
		return message;
	}
	
}
