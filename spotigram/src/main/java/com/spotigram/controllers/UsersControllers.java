package com.spotigram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
		return user.findAll();
	}
	
	@PostMapping("/login")
	public Object findByUser(@RequestBody UserModel requestedUser){
		List<UserModel> pass = user.findByUser(requestedUser.getUsername());
		if(pass.get(0).getPassword().toString().equals(requestedUser.getPassword().toString())) {
			return user.findByUser(requestedUser.getUsername());
		}
		else {
			ObjectNode node = JsonNodeFactory.instance.objectNode();
			ObjectMapper error = new ObjectMapper();
			node.put("error", "Wrong Password");
			try {
				return error.writeValueAsString(node);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			return user.findByUser(requestedUser.getUsername());

		}
		return null;
	}
	
	@PostMapping("/register")
	public List<UserModel> registerUser(@RequestBody UserModel requestedUser){
		System.out.println(requestedUser.getUsername());
		return null;
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> exceptionHandler() {
		return new ResponseEntity<String>("An error has occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
