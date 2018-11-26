package com.spotigram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.spotigram.models.UserModel;
import com.spotigram.services.UserServices;

@RestController
@RequestMapping("users")
public class UsersControllers {
	private UserServices user;
	
	
	public UsersControllers() {
		super();
	}
	
	@Autowired
	public UsersControllers(UserServices user) {
		super();
		this.user = user;
	}

	@GetMapping
	public List<UserModel> findAll(){
		System.out.println(user.findAll());
		return user.findAll();
	}
}
