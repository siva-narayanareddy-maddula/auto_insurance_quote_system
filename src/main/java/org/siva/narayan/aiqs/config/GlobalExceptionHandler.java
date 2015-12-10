package org.siva.narayan.aiqs.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Embed HTML directly into the Javadoc.
 *
 * @author <a href="mailto:siva.narayanareddy.maddula@gmail.com">SivaNarayana Reddy M </a>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = {Exception.class})
	public void exception(Exception ex) {
		System.out.println(ex.getMessage());
	}
}
