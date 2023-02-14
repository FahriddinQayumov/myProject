package com.example.repositoryy;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieCommentRepository extends JpaRepository<Comment, UUID> {
}
