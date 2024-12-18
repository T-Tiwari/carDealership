package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.sendMessage;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class mailController {
	
	 @Autowired
	    private sendMessage emailService;

	 @PostMapping("/booking")
	 public String handleFormSubmission(
	         @RequestParam String name,
	         @RequestParam String email,
	         @RequestParam String message, 
	         @RequestParam String phone, Model model,
	         HttpServletRequest request) throws MessagingException {
		 	String currentUrl = request.getHeader("Referer");
	     
		 try {
		        emailService.sendEmail(name, email, message, phone);
		        return "redirect:" + currentUrl;
		    } 
		 catch (Exception e) {
		        model.addAttribute("error", "Failed to send email: " + e.getMessage());
		        return "error-page";
		    }

	 }
	 
	 @PostMapping("/send")
	 public String handleFormSubmission(
	         @RequestParam String name,
	         @RequestParam String email,
	         @RequestParam String message,  Model model,
	         HttpServletRequest request) throws MessagingException {
		 	String currentUrl = request.getHeader("Referer");
	     
		 try {
		        emailService.sendEmail(name, email, message);
		        return "redirect:" + currentUrl;
		    } 
		 catch (Exception e) {
		        model.addAttribute("error", "Failed to send email: " + e.getMessage());
		        return "error-page";
		    }

	 }
}