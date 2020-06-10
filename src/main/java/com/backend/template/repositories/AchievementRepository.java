package com.backend.template.repositories;

import com.backend.template.dto.output.UserAchievementDto;
import com.backend.template.model.Achievement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * template
 *
 * @author anhdt
 * @created_at 03/06/2020 - 2:12 PM
 * @created_by anhdt
 * @since 03/06/2020
 */
@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Integer> {

    /*@Query(value="select * from social.achievement " +
            "join social.user_achievement " +
            "on achievement.id = user_achievement.achievement_id where user_achievement.user_id=?1", nativeQuery = true)
    Page<Map<String,String>> getListAchievementByUser(long userId, Pageable pageable);*/


    @Query("select new com.backend.template.dto.output.UserAchievementDto (ua.userId, ua.reachedTime, a.content, a.icon, a.title) " +
            "from Achievement a join UserAchievement ua on a.id = ua.achievementId " +
            "where ua.userId=?1 ")
    Page<UserAchievementDto> getListAchievementByUser(long userId, Pageable pageable);
}
