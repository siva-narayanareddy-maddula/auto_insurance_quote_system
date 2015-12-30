package org.siva.narayan.aiqs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.siva.narayan.aiqs.db.entity.SampleEntity;
import org.siva.narayan.aiqs.db.repo.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	@RequestMapping(value = "")
	public String sampleView() {
		return "sample";
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
	
	
	
	
	// SAMPLE TABLE OPERATIONS 
	
	@Autowired
	private SampleRepository sampleRepo;
	
	
	@RequestMapping(value = "/samples/all", method = RequestMethod.GET)
	public @ResponseBody List<SampleEntity> listAll() {
		return sampleRepo.findAll();
	}
	
	@RequestMapping(value = "/samples/{id}", method = RequestMethod.GET)
	public @ResponseBody SampleEntity one(@PathVariable("id") Long id ) {
		final SampleEntity sample = sampleRepo.findOne(id);
		if(sample == null) {
			throw new RuntimeException("Requested Sample is not available with us. Please make sure the 'id' provided is correct.");
		}
		return sample;
	}
	
	@RequestMapping(value = "/samples/remove/all", method = RequestMethod.DELETE)
	public @ResponseBody String deleteAll() {
		sampleRepo.deleteAll();
		return "Deleted all the samples";
	}
	
	@RequestMapping(value = "/samples/remove/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id") Long id) {
		sampleRepo.delete(id);
		return "Deleted the sample : " + id;
	}
	
	@RequestMapping(value = "/samples/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SampleEntity> saveAll(@RequestBody List<SampleEntity> samples) {
		return sampleRepo.save(samples);
	}
	
	
}
