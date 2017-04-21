package com.example.model.catalog;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;

@Entity
@DiscriminatorValue("Album")
public class Album extends Item {

    private String title;
    
    @Lob
    private byte[] cover;
    
    @ElementCollection(fetch=FetchType.LAZY)
    //@CollectionTable(name="")
    @MapKeyColumn(name="position")
    @Column(name="title")
    private Map<Integer,String> tracks;


    public Album() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Album(String description, String title) {
        super(description);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public Map<Integer, String> getTracks() {
        return tracks;
    }

    public void setTracks(Map<Integer, String> tracks) {
        this.tracks = tracks;
    }
    
}
