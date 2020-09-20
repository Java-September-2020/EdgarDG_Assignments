package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String main(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer totalVisits = (Integer) session.getAttribute("count");
		totalVisits++;
		session.setAttribute("count", totalVisits);
		return "main.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		session.getAttribute("count");
		return "counter.jsp";
	}

}
