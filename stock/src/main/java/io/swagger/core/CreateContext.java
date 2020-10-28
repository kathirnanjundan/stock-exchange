package io.swagger.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateContext {

	public static <T> T createInstance(String objName) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		T className=(T) ctx.getBean(objName);  
		return className;
	}
}
