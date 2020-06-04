package com.backend.template.repositories;



import com.backend.template.model.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * template
 *
 * @author longtcs
 * @created_at 02/06/2020 - 15:19
 * @created_by longtcs
 * @since 02/06/2020
 */
@Repository
public interface FollowingRepository extends JpaRepository<Following, String> {

        @Query(value = "select u.full_name as fullName , u.email as email from social.following as f inner join social.user as u on f.following_user_id = u.id and f.user_id = :id",nativeQuery = true)
        List<FollowerDto> getFollowingUserList(@Param("id") long id);

        @Query(value ="select u.full_name as fullName, u.email as email from social.following as f inner join social.user as u on f.user_id = u.id and f.following_user_id = :id",nativeQuery = true)
        List<FollowerDto> getFollowerList(@Param("id") long id);

        Optional<Following>  findByUserIdAndFollowingUserId(BigInteger userId, BigInteger followingUserId);

        public static interface FollowerDto{
                String getFullName();
                String getEmail();
        }
}
