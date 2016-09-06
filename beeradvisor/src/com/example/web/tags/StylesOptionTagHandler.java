package com.example.web.tags;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import com.example.model.BeerRepository;
import com.example.model.Style;
import java.util.stream.Collectors;
import java.util.List;
import java.io.IOException;

public class StylesOptionTagHandler extends TagSupport {

	private String name;
	private List<String> styles;
	private int count = 0;

	public void setName(String name){
		this.name = name;
	}

	public int doStartTag() throws JspException{
		count = 0;
		styles = BeerRepository.getInstance().getStyles()
			.stream().map(Style::getName).collect(Collectors.toList());

		if(styles != null && !styles.isEmpty()){
			try{
				pageContext.getOut().println("<select name = '"+name+"'>");	
			}catch(IOException e){
				e.printStackTrace();
			}
			
			pageContext.setAttribute("style",styles.get(count));

			return EVAL_BODY_INCLUDE;
		}

		return SKIP_BODY;
	}

	public int doAfterBody() throws JspException{
		count ++;
		if(count < styles.size()){
			pageContext.setAttribute("style",styles.get(count));
			return EVAL_BODY_AGAIN;
		}else{
			return SKIP_BODY;
		}
		
	}	

	public int doEndTag() throws JspException{
		if(styles != null && !styles.isEmpty()){
			try{
				pageContext.getOut().println("</select>");	
			}catch(IOException e){
				e.printStackTrace();
			}
			return EVAL_PAGE;
		}
		else{
			return SKIP_PAGE;
		}
	}

}