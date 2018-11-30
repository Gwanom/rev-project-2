package com.spotigram.controllers;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpHeaders;
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
	private JWTHelper jwt = new JWTHelper();
	private ObjectNode result;
	private HttpHeaders responseHeader = new HttpHeaders();
	private ObjectMapper error = new ObjectMapper();
	
	public UsersControllers() {
		super();
	}
	
	@Autowired
	public UsersControllers(UserServices user) {
		super();
		this.user = user;
	}
	
	@PostMapping("renew")
	public Object renewToken(@RequestBody UserModel request, @RequestHeader("Authentication") String auth) {
		List<UserModel> username = user.findByUser(request.getUsername());
		if(!username.isEmpty()) {
			if(comparePasswords(request.getPassword(), username.get(0).getPassword())) {
				responseHeader.set("Authentication", jwt.renewToken(request.getUsername()));
				return new ResponseEntity<String>("",responseHeader,HttpStatus.CREATED);
			}
			else {
				result.put("error", "wrong password");
				return new ResponseEntity<Object>(result,HttpStatus.UNAUTHORIZED);
			}
		}
		return null;
	}
	

	@GetMapping
	public Object findAll(@RequestHeader("Authentication") String auth){
		Boolean renew = jwt.verifyToken(auth);
		if(renew) {
			result.put("error", "renew token");
			return result;
		}
		
		return user.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/login")
	public Object findByUser(@RequestBody UserModel requestedUser){
		result = JsonNodeFactory.instance.objectNode();
		String val = (requestedUser.getUsername() != null) ?  requestedUser.getUsername(): requestedUser.getEmail();
		List<UserModel> username = (requestedUser.getUsername() != null) ?  user.findByUser(requestedUser.getUsername()) : user.findByEmail(requestedUser.getEmail()) ;
		try {
			if(comparePasswords(requestedUser.getPassword(), username.get(0).getPassword())) {
				result.put("info", new ObjectMapper().readTree(new ObjectMapper().writeValueAsString(username)));
				result.put("comments", "");
				result.put("threads", "");
				responseHeader.set("Authentication", jwt.generateToken(username.get(0).getUsername(),false));
				
				return new ResponseEntity<Object>(result,responseHeader,HttpStatus.ACCEPTED);			
			}
			else{
				result.put("error", "Wrong Password");
				return new ResponseEntity<Object>(result,HttpStatus.UNAUTHORIZED);
			}
			
		}catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.put("error", "user does not exist");
		return result;
	}
	
	private Boolean comparePasswords(String storedPassword, String incomingPassword) {
		return PasswordHelper.Hasher.passHasher(storedPassword, incomingPassword);
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
		result = JsonNodeFactory.instance.objectNode();
		
		result.put("error", "Fields are missing");
		try {
			return new ResponseEntity<Object>(error.writeValueAsString(result), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@ExceptionHandler(org.springframework.web.bind.MissingRequestHeaderException.class)
	public ResponseEntity<Object> MissingAuthenticationHeader(){
		result.put("error", "Authentication Header is missing...");
		return new ResponseEntity<Object>(result,HttpStatus.I_AM_A_TEAPOT);
	}
//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<String> exceptionHandler() {
//		return new ResponseEntity<String>("An error has occured", HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
