package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.demo.Entity.Car;
import com.example.demo.Entity.Dealer;
import com.example.demo.Service.CarService;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.DealerRepository;

import jakarta.servlet.http.HttpSession;

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
	public String addProduct(@RequestParam String name,
	                         @RequestParam String model,
	                         @RequestParam String price,
	                         @RequestParam("image") MultipartFile image,
	                         Model modelAttr, // Ensure dealerId is present
	                         HttpSession session) {
		 try {
		        Long dealerId = (Long) session.getAttribute("dealerId");
		        if (dealerId == null) {
		            modelAttr.addAttribute("error", "Dealer is not logged in.");
		            return "redirect:/login"; // Redirect to login if session is invalid
		        }

		        carservice.addCar(name, model, price, image, dealerId);
		    } catch (IOException e) {
		        e.printStackTrace();
		        modelAttr.addAttribute("error", "Failed to upload the car details.");
		    }
		    return "redirect:/dealer/dashboard";
	}

	@GetMapping("/car/image/{carId}")
    public ResponseEntity<byte[]> getCarImage(@PathVariable Long carId) {
        byte[] imageBytes = carservice.getCarImageById(carId);

        // Set HTTP headers to indicate image content type (assuming JPEG here)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }



}
