package com.spotigram.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotigram.models.UserModel;
import com.spotigram.repos.UserRepo;

@Service
public class UserServices {
	
	@Autowired
	private UserRepo userRepo;
	
	public List<UserModel> findAll() {
		return userRepo.findAll();
	}


}
