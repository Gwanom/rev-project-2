package com.spotigram.controllers;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spotigram.models.RolesModel;
import com.spotigram.models.UserModel;
import com.spotigram.services.UserServices;
import com.spotigram.utilities.JWTHelper;
import com.spotigram.utilities.PasswordHelper;

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
		String a = JWTHelper.generateToken("anorexicseal");
		JWTHelper.verifyToken("anorexicseals", "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCIsInJvbGUiOiJ1c2VyIn0.eyJpc3MiOiJhbm9yZXhpY3NlYWwiLCJleHAiOjE1NDMzODQ4MDAsImlhdCI6MTU0MzI5ODQwMH0.tS6DiSuD5VluvI-59al5aTybrbNEJ84SUWtFvDgiKMpMGb1aSOFkuKL6ySRGum0raGNx9qTtREmyo5bf0PTfXA");
		return user.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/login")
	public Object findByUser(@RequestBody UserModel requestedUser, @RequestHeader("Authentication") String auth){
		List<UserModel> username = user.findByUser(requestedUser.getUsername());
		List<UserModel> email = user.findByEmail(requestedUser.getEmail());
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		try {
			if((!username.isEmpty()) && email.isEmpty()) {
				if(PasswordHelper.Hasher.passHasher(requestedUser.getPassword(), username.get(0).getPassword())) {
					//add some logic here to return all the items from that respective user
					result.put("info", new ObjectMapper().readTree(new ObjectMapper().writeValueAsString(username)));
					result.put("comments", "");
					result.put("threads", "");
					return result;
				}
				else {
					result.put("error", "Wrong Password");
					return result;
				}
			}
			if((!email.isEmpty()) && username.isEmpty()) {
				if(PasswordHelper.Hasher.passHasher(requestedUser.getPassword(), email.get(0).getPassword())) {
					//add some logic here to return all the items from that respective user
					result.put("info", new ObjectMapper().readTree(new ObjectMapper().writeValueAsString(email)));
					result.put("comments", "");
					result.put("threads", "");
					return result;
				}
				else {
					result.put("error", "Wrong Password");
					return result;
				}
			}
			else {
				result.put("error", "user does not exist");
				return result;
			}
		}catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@PostMapping("/register")
	public Object registerUser(@Validated @RequestBody UserModel requestedUser){
		List<UserModel> username = user.findByUser(requestedUser.getUsername());
		List<UserModel> email = user.findByEmail(requestedUser.getEmail());
		ObjectNode node = JsonNodeFactory.instance.objectNode();
		ObjectMapper error = new ObjectMapper();
		
		if(username.isEmpty() && (!email.isEmpty())) {
			if(email.get(0).getEmail().equals(requestedUser.getEmail())) {
				node.put("error", "User with that email exists");
				try {
					return error.writeValueAsString(node);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(email.isEmpty() && (!username.isEmpty())) {
			if(username.get(0).getUsername().equals(requestedUser.getUsername())) {
				node.put("error", "User exists with that username");
				try {
					return error.writeValueAsString(node);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if(username.isEmpty() && email.isEmpty()){
			System.out.println("User does not exist with username or email");
			node.put("success", "200");
			
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
		return null;
		

	}
	
	
	@ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
	public ResponseEntity<Object> validateHandler(){
		ObjectNode node = JsonNodeFactory.instance.objectNode();
		ObjectMapper error = new ObjectMapper();
		node.put("error", "Fields are missing");
		try {
			return new ResponseEntity<Object>(error.writeValueAsString(node), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> exceptionHandler() {
		return new ResponseEntity<String>("An error has occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
