package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
    Dealer findByUsername(String username);
    
}
