package com.example.demo.controller;

import com.example.demo.User;
import com.example.demo.dao.UserRepo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class UserController {
	@Autowired
	private UserRepo userrepo;
	
	@GetMapping("/api/users")
	private Iterable<User> getUsers()
	{
//		for(User user:userrepo.findAll())
//		{
//			System.out.println(user.getAd().getId() );
//		}
		return userrepo.findAll();
	}
	
	@PostMapping("/api/user")
	private User createUser(@RequestBody User newuser)
	{
		userrepo.save(newuser);
		return newuser;
	}
}
