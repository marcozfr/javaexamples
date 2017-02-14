package com.example.model.catalog;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class NewsId implements Serializable {
    
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
    public NewsId() {
        super();
    }
    public NewsId(String title, String language) {
        super();
        this.title = title;
        this.language = language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NewsId other = (NewsId) obj;
        if (language == null) {
            if (other.language != null)
                return false;
        } else if (!language.equals(other.language))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }
    
    
    
}
