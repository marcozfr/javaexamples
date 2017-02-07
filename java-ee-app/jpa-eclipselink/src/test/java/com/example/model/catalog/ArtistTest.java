package com.example.model.catalog;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArtistTest extends AbstractTest {
    
    @Test
    public void createArtistWithCDSTest() throws Exception {
        
        Artist a = new Artist();
        a.setFirstName("Bob");
        a.setLastName("Dylan");
        List<CD> appearsOnCDs = new ArrayList<CD>();
        CD cd1 = new CD();
        cd1.setTitle("The wave");
        cd1.setPrice(34.5);
        cd1.setDescription("The wave description");
        appearsOnCDs.add(cd1);
        a.setAppearsOnCDs(appearsOnCDs);
        
        tx.begin();
        
        em.persist(a);
        
        tx.commit();
    }

}
