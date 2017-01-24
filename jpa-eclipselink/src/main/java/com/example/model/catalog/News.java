package com.example.model.catalog;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findNewsByTitleId",query="select n from News n where n.id.title = :title")
public class News {
    
    @EmbeddedId
    private NewsId id;
    
    private String content;

    public NewsId getId() {
        return id;
    }

    public void setId(NewsId id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    
}
