package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUsername(String username);
}
