package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {


	@Autowired
	UserService userService;
	//for loading html ui form
	
	@GetMapping("/register")
	public String sayHello() {
		
		return "user-register";	
	}
	
	 //form action end point for user Registration
	@PostMapping("/user/register")
	public ModelAndView registerUser(HttpServletRequest request) {
		
		//Extract Data From HttpServletRequest to DTO
		UserRegisterDto userRegisterDto=new UserRegisterDto();
			
			userRegisterDto.setEmailId(request.getParameter("email"));
			userRegisterDto.setName(request.getParameter("name"));
			userRegisterDto.setContact(request.getParameter("contact"));
			userRegisterDto.setPassword(request.getParameter("pwd"));
			
			String result=userService.userRegistration(userRegisterDto);
			
			ModelAndView modelAndView=new ModelAndView();
			
			 modelAndView.setViewName("result");
			 modelAndView.addObject("message",result);
			 
			 return modelAndView;
		
	  }
}
