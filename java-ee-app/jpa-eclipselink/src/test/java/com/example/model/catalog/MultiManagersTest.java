package com.example.model.catalog;

import static org.junit.Assert.assertNotEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class MultiManagersTest {

	EntityManager em1 = null;
	EntityManager em2 = null;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogPU");
	
	@Before
	public void initManager(){
		em1= emf.createEntityManager();
		em2= emf.createEntityManager();
	}
	
	@After
	public void endManager(){
		if(em1!=null) em1.close();
		if(em2!=null) em2.close();
		emf.close();
	}
	
	@Test
	public void saveObjects(){
		Album album = new Album();
		album.setDescription("Description");
		album.setPrice(34.4f);
		album.setTitle("Title");
		
		em1.getTransaction().begin();
		
		em1.persist(album);
		
		em1.getTransaction().commit();

		Album album1 = em2.find(Album.class, album.getAlbumId());

		assertNotEquals(album1.toString(),album.toString());
		
	}
	
}
