package com.example.demo.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Dealer;
import com.example.demo.repositories.DealerRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
    private DealerRepository dealerRepository;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
	                                    HttpServletResponse response,
	                                    Authentication authentication) throws IOException, ServletException {

	    Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
	    String username = authentication.getName();

	    if (roles.contains("ROLE_DEALER")) {
	        HttpSession session = request.getSession();
	        Dealer dealer = dealerRepository.findByUsername(username);
	        session.setAttribute("dealerId", dealer.getId());
	        response.sendRedirect("/dealer/dashboard");
	    } else if (roles.contains("ROLE_CLIENT")) {
	        response.sendRedirect("/client/dashboard");
	    } else {
	        response.sendRedirect("/"); // Default redirection
	    }
	}

}

