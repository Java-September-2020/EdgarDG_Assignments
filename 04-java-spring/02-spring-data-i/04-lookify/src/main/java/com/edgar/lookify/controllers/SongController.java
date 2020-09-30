package com.edgar.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edgar.lookify.models.Song;
import com.edgar.lookify.services.SongService;

@Controller
public class SongController {
	@Autowired
	private SongService sService;
	
	//Routes
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dash(Model viewModel) {
		List<Song> allSongs = this.sService.getAllSongs();
		viewModel.addAttribute("allSongs", allSongs);
		return "dashboard.jsp";
	}
	
	//FlashError Reload
	@PostMapping("/dashboard")
	//Create Flash Reload
	
	@RequestMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist) {
		return "search.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen() {
		return "topTen.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String details(@PathVariable("id") Long id) {
		return "details.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String createSong() {
		return "addSong.jsp";
	}

	//New Song Logic
	@PostMapping("/new")
	public String newSong() {
		return "redirect:/dashboard";
	}
	
	//Update Song Logic
	@PostMapping("/edit")
	public String editSong() {
		return "redirect:/dashboard";
	}
	
	//Delete Song Logic
	@PostMapping("/delete")
	public String deleteSong() {
		return "redirect:/dashboard";
	}

	
	
}
