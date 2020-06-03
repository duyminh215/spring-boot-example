package com.backend.template.service;

import com.backend.template.repositories.FollowingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * template
 *
 * @author longtcs
 * @created_at 02/06/2020 - 15:12
 * @created_by longtcs
 * @since 02/06/2020
 */
@Service
public interface FollowService {
    List<FollowingRepository.FollowerDto> getFollowingUserList(int id);

    List<FollowingRepository.FollowerDto> getFollower(int id);

}
