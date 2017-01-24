package com.example.model.catalog;

import javax.persistence.Embeddable;

@Embeddable
public class NewsId {
    
    private String title;
    private String language;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    
    
}
