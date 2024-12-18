package com.example.demo.controllers;

import com.example.demo.Entity.Car;

import java.util.List;

import org.springframework.security.core.Authentication;
import com.example.demo.Entity.Dealer;
import com.example.demo.Entity.User;
import com.example.demo.Service.CarService;
import com.example.demo.repositories.DealerRepository;

import jakarta.servlet.http.HttpSession;

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
    
//    @GetMapping("/dashboard")
//    public String dashboard(@RequestParam Long dealerId, Model model, Authentication authentication) {
//    	String username = authentication.getName();
//        
//        // Fetch cars specific to the dealer
//        List<Car> dealerCars = carService.getCarsByDealer(dealerId);
//        
//        // Add cars and username to the model
//        model.addAttribute("cars", dealerCars);
//        model.addAttribute("username", username);
//        
//        // Pass dealerId back to the view for further operations
//        model.addAttribute("dealerId", dealerId);
//        
//        return "dealer/dashboard";
//    }

//    @GetMapping("/dashboard")
//    public String dashboard(Model model, Authentication authentication) {
//        String username = authentication.getName();
//        //model.addAttribute("cars", carService.getCarsByDealer());
//        model.addAttribute("username", username);
//        return "dealer/dashboard"; 
//    }
    
    @GetMapping("/dashboard")
	public String dealerDashboard(Model model, HttpSession session, Authentication authentication) {
	    Long dealerId = (Long) session.getAttribute("dealerId");
	    if (dealerId == null) {
	        return "redirect:/login";  // Redirect to login if not logged in
	    }

	    List<Car> cars = carService.getCarsByDealer(dealerId);
	    String username = authentication.getName();
	    model.addAttribute("username", username);
	    model.addAttribute("cars", cars);
	    return "dealer/dashboard";  // Assuming this is the name of your view
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
