package com.spotigram.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spotigram.models.SongsModel;

@Repository
public interface SongRepo extends JpaRepository<SongsModel, Integer> {
}
