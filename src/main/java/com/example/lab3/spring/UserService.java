package com.example.lab3.spring;

import com.example.lab3.beans.Role;
import com.example.lab3.beans.User;
import jakarta.servlet.ServletException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    private HashMap<String, User> Users=new HashMap<String, User>();

    public UserService() {
        Users.put("user1",new User("user1","pass1"));
        Users.put("user2",new User("user1","pass1"));
        Users.put("user3",new User("user1","pass1"));
        Users.put("admin",new User("admin","admin", Role.ADMIN));
    }
    public HashMap<String, User> getUsers() {
        return Users;
    }
    public User getUser(String username){
        return Users.get(username);
    }
}
