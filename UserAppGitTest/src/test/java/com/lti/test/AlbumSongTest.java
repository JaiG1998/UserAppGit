package com.lti.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.AlbumSongDao;
import com.lti.model.Album;
import com.lti.model.Song;

public class AlbumSongTest {

	AlbumSongDao dao = new AlbumSongDao();

	@Test
	public void addAlbum() {
		Album album = new Album();
		album.setAlbumName("Rafi ki Yaade");
		album.setGenre("Sad");
		dao.addAlbum(album);

	}

	@Test
	public void addSongsInAlbum() {
		List<Song> songs = new ArrayList<Song>();
		Song song = new Song();
		song.setTitle("Din dhal jaye");
		song.setDuration(4);
		songs.add(song);

		song = new Song();
		song.setTitle("likhe jo khat tujhe");
		song.setDuration(5);
		songs.add(song);

		song = new Song();
		song.setTitle("baharon phool");
		song.setDuration(3);
		songs.add(song);

		dao.addSongsInAlbum(songs, 10000);

	}

	@Test
	public void addNewAlbumWithSongs() {

		Album album = new Album();
		album.setAlbumName("Utkarsh ki harf");
		album.setGenre("toote dil");

		List<Song> songs = new ArrayList<Song>();
		Song song = new Song();
		song.setTitle("Dil ki juban");
		song.setDuration(6);
		songs.add(song);

		song = new Song();
		song.setTitle("ishq ki kahaniya");
		song.setDuration(2);
		songs.add(song);

		song = new Song();
		song.setTitle("Bin bole ezhar");
		song.setDuration(5);
		songs.add(song);

		dao.addNewAlbumWithSongs(songs, album);
	}
	
	@Test
	public void fetchSongsStartingWith(){
		System.out.println(dao.fetchSongsStartingWith('b'));
	}

}
