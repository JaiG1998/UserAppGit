package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb1_song")
public class Song {
	
	@Id
	@SequenceGenerator(name="seq_song",initialValue=10000)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_song")
	private int songId;
	
	@Column
	private String title;
	
	@Column
	private int duration;
	
	@ManyToOne
	@JoinColumn(name="album_id")
	private Album album;

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", title=" + title + ", duration=" + duration + "]";
	}
	
	

}
