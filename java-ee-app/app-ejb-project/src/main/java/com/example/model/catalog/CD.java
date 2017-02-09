package com.example.model.catalog;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CD {
    
    @Id @GeneratedValue
    private Long cdId;
    private String title;
    private String description;
    private Double price;
    
    @OneToMany
    @JoinColumn(name="track_id_fk")
    List<Track> tracks;
    
    public Long getCdId() {
        return cdId;
    }
    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Track> getTracks() {
        return tracks;
    }
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    
    
}
