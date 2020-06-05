package com.backend.template.service;

import com.backend.template.constant.FollowStatusContants;
import com.backend.template.controller.BaseController;
import com.backend.template.exception.DuplicateException;
import com.backend.template.exception.RecordNotFoundException;
import com.backend.template.locale.Translator;
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
public class FollowService {
    @Autowired
    private FollowingRepository followingRepository;


    public List<FollowingRepository.FollowerDto> getFollowingUserList(long userId) {
       return followingRepository.getFollowingUserList(userId);
    }


    public List<FollowingRepository.FollowerDto> getFollower(long userId) {
        return followingRepository.getFollowerList(userId);
    }


    public String followUser(long userId , long followId) {
        if(userId == followId){
            throw new DuplicateException("Duplicate Id");
        }
        Optional<Following> following = followingRepository.findByUserIdAndFollowingUserId(BigInteger.valueOf(userId),BigInteger.valueOf(followId));
        if(following.isPresent()){
           return checkFollowingExisted(following.get());
        }
        return checkFollowingNotExisted(following.get(),userId,followId);
    }
    private String checkFollowingExisted(Following following){
        if(following.getStatus()== FollowStatusContants.FOLLOW) {
            following.setStatus(FollowStatusContants.UNFOLLOW);
            followingRepository.save(following);
            return Translator.toLocale("success.msg.unfollow_user");
        }
        following.setStatus(FollowStatusContants.FOLLOW);
        followingRepository.save(following);
         return Translator.toLocale("success.msg.follow_user");
    }
    private String checkFollowingNotExisted(Following following,long userId , long followId){
        Following following2 = new Following();
        following2.setUserId(BigInteger.valueOf(userId));
        following2.setFollowingUserId(BigInteger.valueOf(followId));
        following2.setStatus(FollowStatusContants.FOLLOW);
        followingRepository.save(following2);
        return Translator.toLocale("success.msg.follow_user");
    }

}
