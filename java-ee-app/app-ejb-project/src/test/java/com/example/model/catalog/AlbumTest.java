package com.example.model.catalog;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.example.model.catalog.AbstractTest;
import com.example.model.catalog.Album;

public class AlbumTest extends AbstractTest {

    @Test
    public void createAlbumTest(){
        Album album = new Album();
        album.setDescription("by the hives");
        album.setPrice(BigDecimal.valueOf(45.5));
        album.setTitle("Recon");
        
        Map<Integer,String> tracks = new HashMap<>();
        tracks.put(1, "Hey");
        tracks.put(2, "Track");
        tracks.put(3, "Lost");
        
        album.setTracks(tracks);
        
        tx.begin();
        
        em.persist(album);
        
        tx.commit();
        
        assertNotNull(album.getItemId());

    }

}
