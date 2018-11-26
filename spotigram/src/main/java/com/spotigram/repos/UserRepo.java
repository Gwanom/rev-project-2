package com.spotigram.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spotigram.models.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer>{
	List<UserModel> findByUsername(String userName);
}
