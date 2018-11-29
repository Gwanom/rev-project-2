package com.spotigram.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotigram.models.PostsModel;
import com.spotigram.models.RepliesModel;

public interface RepliesRepo extends JpaRepository<RepliesModel, Integer> {
	List<RepliesModel> findByParent(PostsModel parent);
}
