package com.demo.auto.site.exceptions;

public class WebElementClickException extends RuntimeException{
	
	public WebElementClickException(String message, Throwable cause)
	{
		super(message,cause);
	}

	public WebElementClickException(String message) {
		super(message);
	}

}
