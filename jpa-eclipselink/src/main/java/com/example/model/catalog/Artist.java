package com.example.model.catalog;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Artist {
    
    @Id @GeneratedValue
    private Long artistId;
    
    private String firstName;
    private String lastName;
    
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name = "join_artist_cd",
        joinColumns=@JoinColumn(name="artist_fk"),
        inverseJoinColumns=@JoinColumn(name="cd_fk"))
    private List<CD> appearsOnCDs;

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CD> getAppearsOnCDs() {
        return appearsOnCDs;
    }

    public void setAppearsOnCDs(List<CD> appearsOnCDs) {
        this.appearsOnCDs = appearsOnCDs;
    }
    
    

}
