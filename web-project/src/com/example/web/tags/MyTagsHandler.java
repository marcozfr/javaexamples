package com.example.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTagsHandler extends SimpleTagSupport {
	
	private static final Integer THREESHOLD = 5000;
    
    private Integer value1;
    private Integer value2;
    
    @Override
    public void setJspContext(JspContext pc) { 
    	/*
    	 *  First
    	 */
    	System.out.println(this.getClass()+" Set JspContext ");
    	super.setJspContext(pc);
    }
    
    @Override
    public void setParent(JspTag parent) {
    	/*
    	 *  Second
    	 */
    	System.out.println(this.getClass()+" Set JspParent");
    	super.setParent(parent);
    }
    
    /*
     *  Third: Set Attributes
     */
    public void setValue1(Integer value1) {
        this.value1 = value1;
    }
    
    public void setValue2(Integer value2) {
        this.value2 = value2;
    }
    
    @Override
    public void setJspBody(JspFragment jspBody) {
    	/*
    	 *  Fourth
    	 */
    	System.out.println(this.getClass()+" Set JspBody");
    	super.setJspBody(jspBody);
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        /*
         *  Fifth
         */
        Integer res = value1.intValue()*value2.intValue();
        
        if(res > THREESHOLD){
        	throw new SkipPageException("Result cannot be greater than "+THREESHOLD);
        }
        
        getJspContext().getOut().append(res.toString());
    }
    
    
    
    public Integer getValue1() {
        return value1;
    }

    public Integer getValue2() {
        return value2;
    }

}
