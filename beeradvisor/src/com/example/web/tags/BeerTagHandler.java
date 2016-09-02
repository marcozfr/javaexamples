package com.example.web.tags;

import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import com.example.model.BeerRepository;

public class BeerTagHandler extends SimpleTagSupport {

	private String user;

	public static String getRandomBeer(){
		int size = BeerRepository.getInstance().getBeers().size();
		int random = ThreadLocalRandom.current().nextInt(0,size-1);
		return BeerRepository.getInstance().getBeers().get(random).getName();
	}
	
	public void doTag() throws JspException, IOException{
		StringBuilder sb = new StringBuilder();
		sb.append("Here's your beer of the day");
		if(user!=null && !user.isEmpty()){
			sb.append(", "+user);
		}
		sb.append(": " +BeerTagHandler.getRandomBeer());
		getJspContext().getOut().write(sb.toString());
	}

	public void setUser(String user){
		this.user = user;
	}

}