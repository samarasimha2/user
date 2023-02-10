package com.akhm.exception;

public class MyCustomUserException extends RuntimeException{
	public MyCustomUserException(String messege)
	{
		super(messege);
	}

}
