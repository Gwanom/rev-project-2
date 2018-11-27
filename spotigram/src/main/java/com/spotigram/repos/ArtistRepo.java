package com.spotigram.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spotigram.models.ArtistsModel;

@Repository
public interface ArtistRepo extends JpaRepository<ArtistsModel, Integer> {
	ArtistsModel findByName(String name);
	
	ArtistsModel findById(int id);
}
