package com.edigest.journalApp.service;

import com.edigest.journalApp.entity.Users;
import com.edigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    Users user = userRepository.findByUserName(username);
    if(user!=null){
       UserDetails userDetails = User.builder()
               .username(user.getUserName())
               .password(user.getPassword())
               .roles(user.getRoles().toArray(new String[0]))
               .build();
       return userDetails;
    }
    throw new UsernameNotFoundException("user not found with username :" + username);
 }
}
