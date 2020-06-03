package com.backend.template.repositories;

import com.backend.template.model.StoryComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoryCommentRepository extends JpaRepository<StoryComment, String> {
}
