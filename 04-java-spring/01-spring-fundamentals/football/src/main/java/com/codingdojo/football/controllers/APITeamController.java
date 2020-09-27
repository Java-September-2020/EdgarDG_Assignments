package com.codingdojo.football.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.football.models.Team;
import com.codingdojo.football.services.TeamService;

@RestController
@RequestMapping("/api")
public class APITeamController {
	private TeamService tService;
	
	public APITeamController(TeamService service) {
		this.tService = service;
	}
	
	
	//Routes
	
	//SELECT * FROM teams
	@RequestMapping("/")
	public List<Team> index() {
		return this.tService.getAllTeams();
	}
	
	//PathVariable Example
	//SELECT FROM teams WHERE id = whatever path var is
	@RequestMapping("{id}")
	public Team getTeam(@PathVariable("id") Long id) {
		return this.tService.getOneTeam(id);
	}
	
	//INSERT INTO teams (name, city, players) VALUE ("whatever", "values", "are");
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Team create(Team newTeam) {
		return this.tService.createTeam(newTeam);
	}
	
	@RequestMapping(value="/team/update/{id}", method=RequestMethod.PUT)
	public Team edit(@PathVariable("id") Long id, Team updatedTeam) {
		return this.tService.updateTeam(updatedTeam);
	}
	
	@RequestMapping(value="/team/delete/{id}", method=RequestMethod.DELETE)
	public String removeTeam(@PathVariable("id") Long id) {
		this.tService.deleteTeam(id);
		return id + " has been removed from the Database.";
	}
	
}
