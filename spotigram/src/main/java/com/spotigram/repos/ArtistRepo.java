package com.spotigram.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spotigram.models.ArtistsModel;
import java.util.List;

@Repository
public interface ArtistRepo extends JpaRepository<ArtistsModel, Integer> {
	List<ArtistsModel> findByName(String name);
}
