package com.example.model.catalog;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.model.catalog.AbstractTest;
import com.example.model.catalog.Track;

public class TrackTest extends AbstractTest{

    @Test
    public void createTrack(){
        
        Track track = new Track();
        track.setTitle("A title");
        track.setDuration(3.45f);
        
        tx.begin();
        
        em.persist(track);
        
        tx.commit();
        
        assertNotNull(track.getTrackId());
        
    }
    
}
