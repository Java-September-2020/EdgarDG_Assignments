package com.edgar.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist, Model viewModel) {
		List<Song> artistSongs = this.sService.getArtistSongs(artist);
		viewModel.addAttribute("artistSongs", artistSongs);
		return "search.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen() {
		return "topTen.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String details(@ModelAttribute("song") Song song, @PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("song", this.sService.getOneSong(id));
		return "details.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String createSong(@ModelAttribute("song") Song song) {
		return "addSong.jsp";
	}

	//New Song Logic
	@PostMapping("/songs/new")
	public String newSong(@Valid @ModelAttribute("song") Song newSong, BindingResult result) {
		if(result.hasErrors()) {
			return "addSong.jsp";
		} else {
			this.sService.createSong(newSong);
			return "redirect:/dashboard";
		}
	}
	
	//Delete Song Logic
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		this.sService.deleteSong(id);
		return "redirect:/dashboard";
	}

	
	
}
