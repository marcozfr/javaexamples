package com.example.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class BodySupportHandler extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1269836109022564960L;
	
	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}
	
	@Override
	public void doInitBody() throws JspException {
		
	    try {
				getBodyContent().writeOut(getBodyContent().getEnclosingWriter());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
