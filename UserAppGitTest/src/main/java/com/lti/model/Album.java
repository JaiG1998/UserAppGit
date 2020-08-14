package com.lti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb1_album")
public class Album {
	
	@Id
	@SequenceGenerator(name="seq_album",initialValue=10000)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_album")
	private int albumId;
	
	@Column
	private String albumName;
	
	@Column
	private String genre;
	
	
	@OneToMany(mappedBy="album", cascade=CascadeType.ALL)
	private List<Song> songs;


	public int getAlbumId() {
		return albumId;
	}


	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}


	public String getAlbumName() {
		return albumName;
	}


	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public List<Song> getSongs() {
		return songs;
	}


	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	
	


}
