package com.codingdojo.football.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.football.models.Team;
import com.codingdojo.football.services.TeamService;

@Controller
public class TeamController {
	@Autowired
	private TeamService tService;
	
	@RequestMapping("/")
	public String index(Model viewModel) {
		List<Team> allTeams = this.tService.getAllTeams();
		viewModel.addAttribute("allTeams", allTeams);
		return "index.jsp";
	}
	
	@RequestMapping("/add")
	public String addATeam() {
		return "add.jsp";
	}
	
	@RequestMapping("/{id}")
	public String showTeam(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("team", this.tService.getOneTeam(id));
		return "show.jsp";
	}
}
