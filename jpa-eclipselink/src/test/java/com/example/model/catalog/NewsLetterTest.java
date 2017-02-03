package com.example.model.catalog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class NewsLetterTest extends AbstractTest {
    
    @Test
    public void createNewsLetterTest(){
        
        List<News> news = new ArrayList<>();
        news.add(new News(new NewsId("Title1","en"),"thi is the content"));
        news.add(new News(new NewsId("Title2","en"),"this is another"));
        NewsLetter nws = new NewsLetter();
        nws.setNewsLetterDate(new Date());
        nws.setNews(news);
        
        tx.begin();
        
        em.persist(nws);
        
        tx.commit();
    }

}
