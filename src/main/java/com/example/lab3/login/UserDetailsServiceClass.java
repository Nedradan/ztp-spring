package com.example.lab3.login;

import com.example.lab3.beans.User;
import com.example.lab3.spring.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceClass implements UserDetailsService {
    private UserService userService;

    public UserDetailsServiceClass(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUser(s);
        return new UserDetailsClass(user);
    }
}
