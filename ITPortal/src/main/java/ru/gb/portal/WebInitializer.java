package ru.gb.portal;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ru.gb.portal.config.ApplicationConfig;
import ru.gb.portal.config.DispatcherServletConfig;



public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{


	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {ApplicationConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {DispatcherServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
