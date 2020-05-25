package com.backend.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.template.model.UserStory;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Long>{

}
