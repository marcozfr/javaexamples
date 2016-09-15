package com.example.web.tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;

public class MyClassicTagsHandler extends TagSupport implements DynamicAttributes {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7329301634391903314L;
	
	
	
	@Override
	public void setDynamicAttribute(String arg0, String arg1, Object arg2) throws JspException {
		attributes.put(arg1, arg2);
	}
	
	private Map<String,Object> attributes = new HashMap<>();
	
	@Override
	public int doStartTag() throws JspException {
		System.out.println("Do Start Tag");
		
		Integer sum = 0;
		
		try {
			
			for(String key :attributes.keySet()){
				String value = (String)attributes.get(key);
				sum = Integer.valueOf(value) + sum;
			}
			
			pageContext.getOut().print("<b>"+sum+"</b>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE; // body content is mepty
	}
	
	@Override
	public int doAfterBody() throws JspException {
		System.out.println("Do After Body");
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("Do End Tag");
		return EVAL_PAGE;
	}

}
