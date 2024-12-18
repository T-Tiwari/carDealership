package com.example.demo.controllers;


import java.util.List;
import org.springframework.security.core.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Car;
import com.example.demo.Service.CarService;

@Controller
public class ClientController {

    @Autowired
    private CarService carService;

    @GetMapping("/client/cars")
    public String viewCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "client/cars";
    }
    
    @GetMapping("/cars")
    public String viewDetails() {
    	return "client/cars";
    }
    
    @GetMapping("/cars/details")
    public String getCarDetails(@RequestParam Long carId, Model model) {
        Car car = carService.getCarById(carId); // Fetch car details by ID
        if (car == null) {
            model.addAttribute("errorMessage", "No car details available");
        } else {
            model.addAttribute("car", car);
        }
        return "client/cars"; // Render the "cars" page with car details
    }

    
    @GetMapping("/client/dashboard")
    public String clientDashboard(Model model, Authentication authentication) {
    	List<Car> cars = carService.getAllCars1();
    	String username = authentication.getName();
        model.addAttribute("cars", cars);
        model.addAttribute("username", username);
        return "client/dashboard";
    }
    
   
    
}

