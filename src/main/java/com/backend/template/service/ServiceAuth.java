package com.backend.template.service;

import com.backend.template.model.User;
import com.backend.template.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ServiceAuth {
    private final UserRepository userRepository;

    private User loggedUser;

    public ServiceAuth(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (isLoggedUser()) {
            long userId = Long.parseLong(authentication.getName());
            loggedUser = userRepository.getOne(userId);
        }
        return loggedUser;
    }

    private boolean isLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }
        return true;
    }
}
