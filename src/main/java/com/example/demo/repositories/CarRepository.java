package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Car;
import com.example.demo.Entity.Dealer;
import com.example.demo.Entity.User;

public interface CarRepository extends JpaRepository<Car, Long> {
	List<Car> findByDealerId(Long dealerId);

	List<Car> findByDealer(Dealer dealer);
}