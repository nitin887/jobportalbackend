package com.jobportalbackend.jobportalbackend.service.impl;

import com.jobportalbackend.jobportalbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.jobportalbackend.jobportalbackend.entity.User user = userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new User(user.getName(), user.getPassword(), new ArrayList<>());
    }
}