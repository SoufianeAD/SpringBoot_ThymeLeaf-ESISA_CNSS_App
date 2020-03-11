package com.spring.main.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.main.models.Student;
import com.spring.main.services.Service;

@org.springframework.stereotype.Controller
@RequestMapping("/controller")
public class Controller {
	
	@Autowired
	private Service service;
	
	private String message;
	
	@PostMapping("/login")
	public String login(@RequestParam("cin") String cin, @RequestParam("massarCode") String massarCode, Model model) {
		Student student = service.login(cin, massarCode);
		if(student == null) {
			message = "Le cin ou le code est incorrecte!";
			model.addAttribute("message", message);
			return "index";
		}
		message = null;
		return "redirect:/controller/fillDataForm/" + cin;
	}
	
	@GetMapping("/fillDataForm/{cin}")
	public String fillDataForm(@PathVariable("cin") String cin, Model model) {
		Student student = service.getStudentRow(cin);
		model.addAttribute("student", student);
		return "FillData";
	}
	
	@PostMapping("/fillData/{cin}")
	public String fillData(@ModelAttribute("student") Student student, @PathVariable("cin") String cin, HttpServletResponse response) {
		student.setCin(cin);
		service.setStudentRow(student);
		return "index";
	}

}
