package org.siva.narayan.aiqs.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for all sorts of exceptions occuring in controller classes.
 * 
 * @author Siva Narayana Reddy M [siva.narayanareddy.maddula@gmail.com]
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = {Exception.class})
	public void exception(Exception ex) {
		System.out.println(ex.getMessage());
	}
}
