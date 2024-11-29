package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.example.demo.Entity.Car;
import com.example.demo.Entity.Dealer;
import com.example.demo.Service.CarService;
import com.example.demo.repositories.DealerRepository;

@Controller
public class addCarController {
	private final CarService carservice;
    private final DealerRepository dealerRepository;
	
	@Autowired
	 public addCarController(CarService carservice, DealerRepository dealerRepository) {
        this.carservice = carservice;
        this.dealerRepository = dealerRepository;
    }
	
    
	@GetMapping("/addNewCar") 
    public String showAddCarForm() {
        return "addNewCar"; 
    }
	
	@PostMapping("/dealer/addCar")
    public String addCar(@ModelAttribute Car car) {
        // Get the logged-in user's username (dealer)
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Fetch the dealer from the database using the username
        Dealer dealer = dealerRepository.findByUsername(username); // Assuming this method exists in DealerRepository

        if (dealer != null) {
            // Associate the dealer with the car
            car.setDealer(dealer);
            
            // Now save the car with the dealer association
            carservice.addCar(car);
        } else {
            return "redirect:/error"; 
        }
        return "redirect:/dealer/dashboard";
    }
//	@PostMapping("/dealer/addNewCar") // This handles the form submission via POST
//    public String addNewCar(Car car) {
//		carservice.addCar(car);
//        // Logic for adding the car
//        return "redirect:/dealer/dashboard"; // Redirect after successfully adding the car
//    }
	
//	@GetMapping("/image/{id}")
//    public ResponseEntity<String> getImage(@PathVariable Long id) {
//        Car car = carservice.getCarById(id);
//        return ResponseEntity.ok()
//                .contentType(MediaType.IMAGE_JPEG) // or MediaType.IMAGE_PNG
//                .body(car.getCarImage());
//    }

}
