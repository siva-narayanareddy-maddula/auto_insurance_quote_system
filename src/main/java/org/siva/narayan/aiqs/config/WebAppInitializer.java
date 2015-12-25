package org.siva.narayan.aiqs.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Main Application initializer : deployment descriptor.
 * 
 * @author Siva Narayana Reddy M [siva.narayanareddy.maddula@gmail.com]
 *
 */
public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext rootContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebAppConfig.class);
		
		context.setDisplayName("AIQS");
		rootContext.addListener(new ContextLoaderListener(context));
		
		ServletRegistration.Dynamic dispatcher = rootContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
		dispatcher.addMapping("/");
		dispatcher.setLoadOnStartup(1);
	}

}
