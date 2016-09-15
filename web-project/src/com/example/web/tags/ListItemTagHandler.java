package com.example.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ListItemTagHandler extends TagSupport {

	private String value;

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		
		
		ListTagHandler parentTag  = (ListTagHandler)findAncestorWithClass(this, ListTagHandler.class);
//		ListTagHandler parentTag = (ListTagHandler) getParent();
		parentTag.addChildValue(value);
		return EVAL_PAGE;
	}
}
