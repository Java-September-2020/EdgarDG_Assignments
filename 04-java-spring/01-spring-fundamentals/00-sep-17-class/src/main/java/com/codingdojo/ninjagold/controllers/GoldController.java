package com.codingdojo.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
@GetMapping("/")
public String formGold(HttpSession session, Model viewModel) {
	if (session.getAttribute("gold") == null) {
		session.setAttribute("gold", 0);
	}
	viewModel.addAttribute("gold", session.getAttribute("gold"));
	return "index.jsp";
	}


@PostMapping("/findgold")
public String getGold(HttpSession session, @RequestParam("building") String building) {
	ArrayList<String> activity = new ArrayList<String>();
	if (session.getAttribute("activityLog") == null) {
		session.setAttribute("activityLog", activity);
	}
	
	int gold = (int)session.getAttribute("gold");
	int goldThisTurn = 0;
	Random r = new Random();
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
	
	ArrayList<String> activities = (ArrayList<String>)session.getAttribute("activityLog");
		if (building.equals("farm")) {
		int newNum = r.nextInt((20 - 10) +1) + 10;
		activities.add("You entered a farm and earned" + goldThisTurn + formatter.format(now) + ".");
	} else if (building.equals("cave")) {
		int newNum = r.nextInt((10 - 5) +1) + 10;
		activities.add("You entered a farm and earned" + goldThisTurn + formatter.format(now) + ".");
	} else if (building.equals("house")) {
		int newNum = r.nextInt((5 - 2) +1) + 10;
		activities.add("You entered a farm and earned" + goldThisTurn + formatter.format(now) + ".");
	} else if (building.equals("casino")) {
		int newNum = r.nextInt((50 + 50) + 1) + -50;
		if (goldThisTurn < 0) {
			activities.add("You entered a farm and lost" + goldThisTurn + formatter.format(now) + ". Ouch!");
		} else {
			activities.add("You entered a farm and earned" + goldThisTurn + formatter.format(now) + ".");
		}
	}
	int totalGold = gold + goldThisTurn;
	session.setAttribute("gold", totalGold);
		
		
	return "redirect:/";
	}
}
