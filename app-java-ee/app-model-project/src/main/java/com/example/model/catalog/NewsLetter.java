package com.example.model.catalog;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class NewsLetter {
    
    @Id
    @GeneratedValue
    private Long newsLetterId;
    
    @Temporal(TemporalType.DATE)
    private Date newsLetterDate;
    
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="NEWSLETTERID_FK")
    private List<News> news;

    public Long getNewsLetterId() {
        return newsLetterId;
    }

    public void setNewsLetterId(Long newsLetterId) {
        this.newsLetterId = newsLetterId;
    }

    public Date getNewsLetterDate() {
        return newsLetterDate;
    }

    public void setNewsLetterDate(Date newsLetterDate) {
        this.newsLetterDate = newsLetterDate;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    
    
}
