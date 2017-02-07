package com.example.model.catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long trackId;
    private String title;
    private Float duration;
    private byte[] wav;
    private String description;

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public byte[] getWav() {
        return wav;
    }

    public void setWav(byte[] wav) {
        this.wav = wav;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
