package com.example.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTagsHandler extends SimpleTagSupport {
    
    private Integer value1;
    private Integer value2;
    
    
    public Integer getValue1() {
        return value1;
    }



    public void setValue1(Integer value1) {
        this.value1 = value1;
    }



    public Integer getValue2() {
        return value2;
    }



    public void setValue2(Integer value2) {
        this.value2 = value2;
    }



    @Override
    public void doTag() throws JspException, IOException {
        
        Integer res = value1.intValue()*value2.intValue();
        
        getJspContext().getOut().append(res.toString());
        
    }

}
