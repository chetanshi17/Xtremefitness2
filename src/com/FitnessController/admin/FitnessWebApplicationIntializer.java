package com.FitnessController.admin;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FitnessWebApplicationIntializer extends
AbstractAnnotationConfigDispatcherServletInitializer{

	
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {FitnessConfig.class};
	}
	
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {FitnessConfig.class};
	}

	protected String[] getServletMappings() {
		System.out.println("**** getservletMapping");
		return new String[] {"*.jlc"};
	}

}
