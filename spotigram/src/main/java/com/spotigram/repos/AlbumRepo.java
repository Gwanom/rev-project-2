package com.spotigram.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spotigram.models.AlbumsModel;
import java.util.List;

@Repository
public interface AlbumRepo extends JpaRepository<AlbumsModel, Integer> {
	List<AlbumsModel> findByTitle(String title);
	
	AlbumsModel findById(int id);
}
