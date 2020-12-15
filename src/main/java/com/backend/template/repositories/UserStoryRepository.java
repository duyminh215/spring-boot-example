package com.backend.template.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.template.model.UserStory;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

    @Query(value = "SELECT * FROM social.user_story where user_story.user_id=?1 ", nativeQuery = true)
    Page<UserStory> getPageStoryByUser(Long userId, Pageable p);

    @Query(value = "SELECT * FROM social.user_story where id=?1 and user_id=?2 ", nativeQuery = true)
    UserStory getStoryDetail(Long storyId, Long userId);

}
