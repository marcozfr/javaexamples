package com.example.web.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ListTagHandler extends TagSupport {

	private String title;
	private List<String> values;
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void addChildValue(String value){
		values.add(value);
	}
	
	@Override
	public int doStartTag() throws JspException {
		values = new ArrayList<>();
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		
		try {
			if(title!=null){
				pageContext.getOut().print("<div><h3>"+title+"</h3></div>");
			}
			pageContext.getOut().print("<div><ul>");
			for(String value : values){
				pageContext.getOut().print("<li>"+value+"</li>");
			}
			pageContext.getOut().print("</ul></div>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return EVAL_PAGE;
	}
	
}
