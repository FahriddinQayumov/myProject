package com.example.repositoryy;

import com.example.movieuz.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<Like, UUID> {
    public Long countAllByMovieId(UUID id);
    public Long countAllByMovieIdAndIsLikeTrue(UUID id);

    public List<Like> getAllByUserId(UUID id);
    public List<Like> getAllByMovieId(UUID id);
}
