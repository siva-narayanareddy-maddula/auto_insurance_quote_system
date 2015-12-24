package org.siva.narayan.aiqs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.knappsack.swagger4springweb.controller.ApiDocumentationController;
import com.wordnik.swagger.model.ApiInfo;

/**
 * Documentation Controller to load swagger resources and render documentation view.
 * 
 * @author Siva Narayana Reddy M [siva.narayanareddy.maddula@gmail.com]
 *
 */
@RestController
@RequestMapping(value = "/documentation")
public class DocumentationController extends ApiDocumentationController {

	@Autowired
	public DocumentationController(Environment env) {
		setBaseControllerPackage("org.siva.narayan.aiqs");
		setApiVersion("v1");
		setApiInfo(new ApiInfo("Auto Insurance Quote System", "", "", "", "siva.narayanareddy.maddula@gmail.com", ""));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView documentation() {
		return new ModelAndView("documentation");
	}
}

