package com.example.groceryPortal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.groceryPortal.entities.User_Privileges;
import com.example.groceryPortal.repositories.UserPrivilegeRepository;

@Service
public class UserPrivilegeService {
    @Autowired
    private UserPrivilegeRepository userPrivilegeRepository;

	public Iterable<User_Privileges> GetAllUsers()
	{
	   return userPrivilegeRepository.findAll();
	}
	
    public User_Privileges GetUserByName(String name) {
    	User_Privileges user = userPrivilegeRepository.findByName(name);
    	if (user == null) {
    		throw new RuntimeException("User Not Found!");
    	}
    	return user;
    }
     
    public boolean ConfirmUserPassword(User_Privileges user, String password) {
    	return(user.getPassword().equals(password));
    }
    
    public boolean isAdmin(User_Privileges user) {
    	return(user.getPrivilege().equals("admin"));
    }
}
