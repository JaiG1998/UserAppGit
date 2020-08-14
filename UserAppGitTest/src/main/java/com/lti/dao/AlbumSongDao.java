package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Album;
import com.lti.model.Song;
import com.lti.model.Transaction;

public class AlbumSongDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public void addAlbum(Album album) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();

		tx.begin();
		em.merge(album);
		tx.commit();
	}

	public void addSongsInAlbum(List<Song> songs, int albumId) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();	
		
		Album album = em.find(Album.class, albumId);
		album.setSongs(songs);
		
		for(Song s : songs){
			s.setAlbum(album);
		}
		
		tx = em.getTransaction();
		
		tx.begin();
		em.merge(album);
		tx.commit();
		
		
	}
	
	public void addNewAlbumWithSongs(List<Song> songs, Album album) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();	
		
		
		album.setSongs(songs);
		
		for(Song s : songs){
			s.setAlbum(album);
		}
		
		tx = em.getTransaction();
		
		tx.begin();
		em.merge(album);
		tx.commit();
		
		
	}
	
	public List<Song> fetchSongsStartingWith(char ch){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();	
		
		String sql = "select s from Song s where s.title like :c";
		TypedQuery<Song> query = em.createQuery(sql, Song.class);
		query.setParameter("c", ch+"%");
		List<Song> resultList = query.getResultList();
		return resultList;
	}

}
