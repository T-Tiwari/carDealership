package com.example.demo.Service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Client;
import com.example.demo.Entity.Dealer;
import com.example.demo.Entity.User;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.DealerRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class RegistrationService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DealerRepository dealerRepository;
    
    @Autowired
    private UserRepository userRepository;

    public void registerClient(Client client) {
    
    	clientRepository.save(client);
    	
        // Save client login details in the user table
        User user = new User();
        user.setUsername(client.getUsername());
        user.setPassword(passwordEncoder.encode(client.getPassword()));
        user.setRole("ROLE_CLIENT");
        user.setEnabled(true);
        userRepository.save(user);
        
        
    
    }

    public void registerDealer(Dealer dealer) {
        dealerRepository.save(dealer);
        
     // Save dealer login details in the user table
        User user = new User();
        user.setUsername(dealer.getUsername());
        user.setPassword(passwordEncoder.encode(dealer.getPassword()));
        user.setRole("ROLE_DEALER");
        user.setEnabled(true);
        userRepository.save(user);
        
    }
    
    
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void registerClient1(Client client) {
        // Encrypt password before saving
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        // Save client to database
    }

    public void registerDealer1(Dealer dealer) {
        // Encrypt password before saving
        dealer.setPassword(passwordEncoder.encode(dealer.getPassword()));
        // Save dealer to database
    }
}

