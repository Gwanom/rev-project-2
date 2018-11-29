package com.spotigram.services;

import java.util.List;

import com.spotigram.models.PostsModel;
import com.spotigram.models.RepliesModel;
import com.spotigram.repos.RepliesRepo;

public class RepliesService {

	private RepliesRepo repliesRepo;
	
	public List<RepliesModel> findByParent(PostsModel parent){
		return repliesRepo.findByParent(parent);
	}
}
