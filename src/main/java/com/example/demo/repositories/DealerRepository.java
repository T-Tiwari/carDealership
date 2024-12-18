package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Car;
import com.example.demo.Entity.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
    Dealer findByUsername(String username);
    
//    @Query("SELECT c FROM Car c WHERE c.dealer.id = :dealerId")
//    List<Car> findCarsByDealerId(@Param("dealerId") Long dealerId);

    
}
