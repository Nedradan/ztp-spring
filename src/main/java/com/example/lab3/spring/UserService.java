package com.example.lab3.spring;

import com.example.lab3.beans.User;
import jakarta.servlet.ServletException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    private HashMap<String, String> Users=new HashMap<String, String>();

    public UserService() {
        Users.put("user1","pass1");
        Users.put("user2","pass2");
        Users.put("user3","pass3");
        Users.put("user4","pass4");
    }
    public HashMap<String, String> getUsers() {
        return Users;
    }
    public User getUser(String username){
        return new User(username,Users.get(username));
    }
}
