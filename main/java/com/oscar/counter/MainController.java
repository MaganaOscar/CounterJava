package com.oscar.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		} else {
			session.setAttribute("count", (Integer)session.getAttribute("count") + 1);
		}
		model.addAttribute("count", (Integer)session.getAttribute("count"));
		return "home.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		model.addAttribute("count", (Integer)session.getAttribute("count"));
		return "counter.jsp";
	}
	
	@RequestMapping("/counter2")
	public String counter2(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 2);
		} else {
			session.setAttribute("count", (Integer)session.getAttribute("count") + 2);
		}
		model.addAttribute("count", (Integer)session.getAttribute("count"));
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String rest(HttpSession session, Model model) {
		session.setAttribute("count", 0);
		model.addAttribute("count", session.getAttribute("count"));
		return "counter.jsp";
	}
	
}
