package com.example.demo.controllers;

import com.example.demo.Entity.Car;
import org.springframework.security.core.Authentication;
import com.example.demo.Entity.Dealer;
import com.example.demo.Entity.User;
import com.example.demo.Service.CarService;
import com.example.demo.repositories.DealerRepository;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dealer")
public class DealerController {

	private final CarService carService;
    private final DealerRepository dealerRepository;
    
    // Constructor-based dependency injection
    public DealerController(CarService carService, DealerRepository dealerRepository) {
        this.carService = carService;
        this.dealerRepository = dealerRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        String username = authentication.getName();
        model.addAttribute("cars", carService.getCarsByDealer());
        model.addAttribute("username", username);
        return "dealer/dashboard"; 
    }
    
    
 // Handle form submission to add a new car
    
//
//    @GetMapping("/editCar/{carId}")
//    public String editCar(@PathVariable Long carId, Model model) {
//        Car car = carService.getCarById(carId);
//        model.addAttribute("car", car);
//        return "dealer/editCar"; // Return the page where you can edit car details
//    }
//
//    @PostMapping("/updateCar/{carId}")
//    public String updateCar(@PathVariable Long carId, @ModelAttribute Car car) {
//        carService.updateCar(carId, car);
//        return "redirect:/dealer/dashboard";
//    }
//
//    @PostMapping("/deleteCar/{carId}")
//    public String deleteCar(@PathVariable Long carId) {
//        carService.deleteCar(carId);
//        return "redirect:/dealer/dashboard";
//    }
}
