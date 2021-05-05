package com.example.groceryPortal.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.groceryPortal.entities.User_Privileges;

public interface UserPrivilegeRepository extends CrudRepository<User_Privileges, Integer>{
	public User_Privileges findByName(String Name);
}
