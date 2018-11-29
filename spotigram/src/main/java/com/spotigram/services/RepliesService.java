package com.spotigram.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotigram.models.PostsModel;
import com.spotigram.models.RepliesModel;
import com.spotigram.repos.PostRepo;
import com.spotigram.repos.RepliesRepo;

@Service
public class RepliesService {

	@Autowired
	private RepliesRepo repliesRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	public List<RepliesModel> findAll(){
		System.out.println("repliesservice.findall");
		return repliesRepo.findAll();
	}
	
	public List<RepliesModel> findByParent(int parentId){
		System.out.println("repliesservice.findbyparent");
		PostsModel parent = postRepo.findByPostId(parentId);
		return repliesRepo.findByParent(parent);
	}
}
