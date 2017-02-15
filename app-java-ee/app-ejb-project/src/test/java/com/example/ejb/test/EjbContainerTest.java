package com.example.ejb.test;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class EjbContainerTest {

	protected static EJBContainer ejbContainer;
	protected static Context context;
	
	@BeforeClass
	public static void createContainer(){
		Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
		ejbContainer = EJBContainer.createEJBContainer(properties);
		context = ejbContainer.getContext();
	}
	
	@AfterClass
	public static void endContainer() throws NamingException{
		context.close();
		ejbContainer.close();
	}
	
}
