package com.backend.template.service;

import com.backend.template.controller.BaseController;
import com.backend.template.exception.DuplicateException;
import com.backend.template.exception.RecordNotFoundException;
import com.backend.template.model.Following;
import com.backend.template.repositories.FollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * template
 *
 * @author longtcs
 * @created_at 02/06/2020 - 15:13
 * @created_by longtcs
 * @since 02/06/2020
 */
@Component
public class FollowServiceImpl extends BaseController implements FollowService {
    @Autowired
    private FollowingRepository followingRepository;

    @Override
    public List<FollowingRepository.FollowerDto> getFollowingUserList() {
       return followingRepository.getFollowingUserList(getLoginedUser().getId());
    }

    @Override
    public List<FollowingRepository.FollowerDto> getFollower() {
        return followingRepository.getFollowerList(getLoginedUser().getId());
    }

    @Override
    public Following followUser(long followId) {
        Optional<Following> following1 = followingRepository.findByUserIdAndFollowingUserId(BigInteger.valueOf(getLoginedUser().getId()),BigInteger.valueOf(followId));
        if(following1.isPresent()){
            throw new DuplicateException("Followed");
        }else{
            Following following2 = new Following();
            following2.setUserId(BigInteger.valueOf(getLoginedUser().getId()));
            following2.setFollowingUserId(BigInteger.valueOf(followId));
            followingRepository.save(following2);
            return following2;
        }
    }


}
