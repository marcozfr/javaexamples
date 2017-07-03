package com.example.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LegalDocument {
    
    private Long id;
    private String summary;
    private String title;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    

}
