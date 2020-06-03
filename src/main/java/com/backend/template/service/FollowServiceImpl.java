package com.backend.template.service;

import com.backend.template.repositories.FollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * template
 *
 * @author longtcs
 * @created_at 02/06/2020 - 15:13
 * @created_by longtcs
 * @since 02/06/2020
 */
@Component
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowingRepository followingRepository;

    @Override
    public List<FollowingRepository.FollowerDto> getFollowingUserList(int id) {
       return followingRepository.getFollowingUserList(id);
    }

    @Override
    public List<FollowingRepository.FollowerDto> getFollower(int id) {
        return followingRepository.getFollowerList(id);
    }



}
