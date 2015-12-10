package org.siva.narayan.aiqs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	@RequestMapping
	public String loginView() {
		return "login";
	}

	
	@RequestMapping(value = "/ex")
	public void exception() {
		throw new RuntimeException("Hi..Catch me...");
	}
	
}
