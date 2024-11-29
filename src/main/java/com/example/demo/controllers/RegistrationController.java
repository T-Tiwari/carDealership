package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Client;
import com.example.demo.Entity.Dealer;
import com.example.demo.Service.RegistrationService;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Show registration options (Client or Dealer)
//    @GetMapping("/register")
//    public String showRegistrationOptions() {
//        return "register";
//    }

    // Show Client Registration Form
    @GetMapping("/register/client")
    public String showClientRegistrationForm(@ModelAttribute Client client) {
        return "register_client";
    }

    // Show Dealer Registration Form
    @GetMapping("/register/dealer")
    public String showDealerRegistrationForm(@ModelAttribute Dealer dealer) {
        return "register_dealer";
    }

    // Handle Client Registration (POST)
    @PostMapping("/register/client")
    public String registerClient(@ModelAttribute Client client) {
        registrationService.registerClient(client);
        return "redirect:/login"; // Redirect to login after registration
    }

    // Handle Dealer Registration (POST)
    @PostMapping("/register/dealer")
    public String registerDealer(@ModelAttribute Dealer dealer) {
        registrationService.registerDealer(dealer);
        return "redirect:/login"; // Redirect to login after registration
    }
}