package com.spotigram.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spotigram.models.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer>{
}
