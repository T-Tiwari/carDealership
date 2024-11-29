package com.example.demo.Service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Car;
import com.example.demo.Entity.Dealer;
import com.example.demo.Entity.User;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.DealerRepository;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DealerRepository dealerRepository;
    

    public List<Car> getCarsByDealer() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Dealer dealer = dealerRepository.findByUsername(username);
        return carRepository.findByDealer(dealer);  // Assuming this method exists in CarRepository
    }
    
    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    }

    public void addCar(Car car) {
        // Get the logged-in dealer's username
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        
        // Fetch the dealer from the database using the username
        Dealer dealer = dealerRepository.findByUsername(username);
        
        // Associate the car with the logged-in dealer
        car.setDealer(dealer);
        
        // Save the car to the database
        carRepository.save(car);
    }
    
    public List<Car> getAllCars1() {
        return carRepository.findAll();
    }
    
    
//    // Update car details
//    public Car updateCar(Long carId, Car carDetails) {
//        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
//        car.setCarName(carDetails.getCarName());
//        car.setCarModel(carDetails.getCarModel());
//        car.setPrice(carDetails.getPrice());
//        car.setCarImage(carDetails.getCarImage());
//        return carRepository.save(car);
//    }
//
//    // Delete a car
//    public void deleteCar(Long carId) {
//        carRepository.deleteById(carId);
//    }
//
	public Object getAllCars() {
		// TODO Auto-generated method stub
		return null;
	}
}

