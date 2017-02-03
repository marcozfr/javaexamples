package com.example.model.catalog;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

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
