package com.spotigram.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.spotigram.models.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer>{
	List<UserModel> findByUsername(String userName);
	
	// queries like these require for them to be void or have an integer value
	//@Query(value = "INSERT INTO users (username,u_password,user_first_name,user_last_name,user_email,user_role,isbanned) VALUES (:username,:password,:firstname,:lastname,:email,:role,:isbanned)", nativeQuery=true)
	//public void newUser(@Param("username") String username,@Param("password") String password,@Param("firstname") String firstname,@Param("lastname") String lastname,@Param("email") String email,@Param("role") int role, @Param("isbanned") Boolean isbanned);
	
}
