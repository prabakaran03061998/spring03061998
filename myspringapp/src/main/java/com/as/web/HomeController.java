package com.as.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abytz.model.User;

@RestController
@RequestMapping(value = "/")
public class HomeController {
	
	private List<User> userList =  null;
	
	@RequestMapping(value = "/home")
	public String home() {
		return "Hello World";
		
	}
	
	@RequestMapping(value = "/getuser")
	public List<User> getSingleUsers() {
		if(userList == null)
			userList =  new ArrayList<User>();
			return userList;
	}
	
	@RequestMapping(value = "/getuserlist")
	public List<User> getUsers() {
		if(userList == null)
			userList =  new ArrayList<User>();
		
		return userList;
	}
	
	@PostMapping(value = "/createuser")
	public List<User> getUsers(@RequestBody User user) {
		
		if(userList == null)
			userList =  new ArrayList<User>();
		userList.add(user);
		return userList;
	}
	
	@PostMapping(value = "/createuser1")
	public List<User> getUserss(HttpServletRequest request) {
		System.out.println(request);
		if(userList == null)
			userList =  new ArrayList<User>();
		//userList.add(user);
		return userList;
	}
	
	@RequestMapping(value = "/getdummyuser/{userId}")
	public User getUserId(@PathVariable String userId) {
		if(userId.contentEquals("P12345")) {
			return new User("P12345", "Prabha", "Karan", 231115555, "prabha@123.com", "Trichy", "Prabha123@");
		}else {
			return new User();
		}
	}
	@RequestMapping(value = "/getuser/{userId}")
	public User getEmailId(@PathVariable String userId )
	{
		User userobj = new User();
		if(userList !=null) {
			for(User user: userList) {
				if(user.getUserId().equalsIgnoreCase(userId)) {
					userobj = user;
				}
			}
		}	
		return userobj;
	}
	
	

}
