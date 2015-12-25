package org.siva.narayan.aiqs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knappsack.swagger4springweb.annotation.ApiExclude;

/**
 * A Sample Controller to test swagger wiring.
 * 
 * @author Siva Narayana Reddy M [siva.narayanareddy.maddula@gmail.com]
 *
 */
@Controller
@SuppressWarnings("serial")
public class SampleController {
	
	@ApiExclude()
	@RequestMapping(value = "/login")
	public String loginView() {
		return "login";
	}

	@ApiExclude()
	@RequestMapping(value = "/ex")
	public void exception() {
		throw new RuntimeException("Hi..Catch me...");
	}
	
	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	public @ResponseBody String helloWorld() {
		return "Hello World";
	}
	
	@RequestMapping(value = "/greetMe", method = RequestMethod.GET)
	public @ResponseBody String greetMeRequestParam(@RequestParam String name) {
		return "Hi " + name + "! How are you doing?";
	}
	
	@RequestMapping(value = "/greetMe/{name}", method = RequestMethod.GET)
	public @ResponseBody String greetMePathVariable(@PathVariable String name) {
		return "Hi " + name + "! How are you doing?";
	}
	
	@RequestMapping(value = "/helloList", method = RequestMethod.GET)
	public @ResponseBody List<String> helloList() {
		return new ArrayList<String>() {{
			add("Siva");
			add("Narayana");
			add("Reddy");
		}};
	}

	@RequestMapping(value = "/helloMap", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> helloMap() {
		return new HashMap<String, String>() {{
			put("firstname", "Siva Narayana");
			put("laststname", "Reddy");
			put("location", "India");
		}};
	}
	
}
