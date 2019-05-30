package main.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice //Marks the class as a ControllerAdvice
public class ExceptionController
{


	//Specifies that the method will handle exceptions
	@ExceptionHandler(value = Exception.class)
	public String HandlerError(HttpServletRequest req, Exception exception)
	{
	
		return "error";
	}
	
	
	
}
