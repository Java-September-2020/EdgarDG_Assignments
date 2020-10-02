package com.edgar.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.lookify.models.Song;
import com.edgar.lookify.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository sRepo;
	
	//Get All Songs
	public List<Song> getAllSongs() {
		return this.sRepo.findAll();
	}
	
	//Get One Song
	public Song getOneSong(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
	//Get All Songs By Artist
	public List<Song> getArtistSongs(String artistName) {
		return this.sRepo.findByArtistContaining(artistName);
	}
	
	//Top 10 Sorted By Rating
	public List<Song> topTenByRating() {
		return this.sRepo.findTop10ByOrderByRatingDesc();
	}
	
	//Save New Song
	public Song createSong(Song newSong) {
		return this.sRepo.save(newSong);
	}
	
	//Update Song
	public Song updateSong(Song updatedSong) {
		return this.sRepo.save(updatedSong);
	}
	
	//Delete Song
	public void deleteSong(Long id) {
		this.sRepo.deleteById(id);
	}
	
	
	
}
