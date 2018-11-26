package com.spotigram.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spotigram.models.RolesModel;
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

		}
		return null;
	}
	
	@PostMapping("/register")
	
	public void registerUser(@Validated @RequestBody UserModel requestedUser){
		UserModel newUser = new UserModel();
		RolesModel role = new RolesModel();
		newUser.setEmail(requestedUser.getEmail());
		newUser.setFirstName(requestedUser.getFirstName());
		newUser.setLastName(requestedUser.getLastName());
		newUser.setIsbanned(false);
		newUser.setUsername(requestedUser.getUsername());
		newUser.setPassword(requestedUser.getPassword());
		role.setRole_name("user");
		role.setSg_role_id(1);
		newUser.setRoles(role);
		user.save(newUser);
		
	}
	
	/*
	 * exception handler to validate the registration portion
	 * */
	
//	@ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
//	public ResponseEntity<Object> validateHandler(){
//		ObjectNode node = JsonNodeFactory.instance.objectNode();
//		ObjectMapper error = new ObjectMapper();
//		node.put("error", "Fields are missing");
//		try {
//			return new ResponseEntity<Object>(error.writeValueAsString(node), HttpStatus.INTERNAL_SERVER_ERROR);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	
//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<String> exceptionHandler() {
//		return new ResponseEntity<String>("An error has occured", HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
