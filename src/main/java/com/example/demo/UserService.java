package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
	@Autowired
	UserRepository repository;
	
	public String userRegistration(UserRegisterDto userRegisterDto) {
		
		
		//convert dto instance to entity object.
	UsersInfo info=new UsersInfo();
	
	 info.setEmailId(userRegisterDto.getEmailId());
	 info.setName(userRegisterDto.getName());
	 info.setContact(userRegisterDto.getContact());
	 info.setPassword(userRegisterDto.getPassword());
	 
	  repository.save(info);
	     return "User Registration Successfully";
	     
	     
	
	
}
}
