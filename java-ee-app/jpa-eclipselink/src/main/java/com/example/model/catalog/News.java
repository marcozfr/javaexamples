package com.example.model.catalog;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
@NamedQuery(name="findNewsByTitleId",query="select n from News n where n.id.title = :title")
public class News {
    
    @EmbeddedId
    private NewsId id;
    
    private String content;
    
    @OneToMany(fetch=FetchType.LAZY)
    @OrderBy("postedDate desc")
    private List<Comment> comments;
    
    public News() {
        super();
    }

    public News(NewsId id, String content) {
        super();
        this.id = id;
        this.content = content;
    }

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
