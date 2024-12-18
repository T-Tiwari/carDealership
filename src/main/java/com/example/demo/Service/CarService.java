package com.example.demo.Service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Car;
import com.example.demo.Entity.Dealer;
import com.example.demo.Entity.User;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.DealerRepository;

import java.io.IOException;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DealerRepository dealerRepository;
    
    
//    public Car getCarById(Long id) {
//        return carRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
//    }
    


    public void addCar(String name, String model, String price, MultipartFile image, Long dealerId) throws IOException {
        Dealer dealer = dealerRepository.findById(dealerId)
                .orElseThrow(() -> new IllegalArgumentException("Dealer not found"));

        Car car = new Car();
        car.setCarName(name);
        car.setCarModel(model);
        car.setPrice(price);
        car.setImage(image.getBytes());
        car.setDealer(dealer);

        carRepository.save(car);
    }

    public List<Car> getCarsByDealer(Long dealerId) {
        Dealer dealer = dealerRepository.findById(dealerId)
                .orElseThrow(() -> new IllegalArgumentException("Dealer not found"));
        return carRepository.findByDealer(dealer);
    }


    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    }

    public byte[] getCarImageById(Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + carId));
        return car.getImage();  // Assuming the image is stored as a byte array in Car entity
    }
    
    public List<Car> getAllCars1() {
        return carRepository.findAll();
    }
    
    

	public Object getAllCars() {
		// TODO Auto-generated method stub
		return null;
	}
}

