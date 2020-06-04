package com.backend.template.controller;

import com.backend.template.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * template
 *
 * @author longtcs
 * @created_at 02/06/2020 - 15:00
 * @created_by longtcs
 * @since 02/06/2020
 */
@RestController
@RequestMapping("/follower")
public class FollowController extends BaseController {
    @Autowired
    private FollowService followService;

    @GetMapping("/following-list")
    public ResponseEntity<?> getFollowingUserList(){

        return ResponseEntity.ok(followService.getFollowingUserList(getLoginedUser().getId()));
    }
    @GetMapping("/follower-list")
    public ResponseEntity<?> getFollowerList(){

        return ResponseEntity.ok(followService.getFollower(getLoginedUser().getId()));
    }

    @PostMapping("/following")
    public ResponseEntity<?> followUser(@RequestParam("followid")long followId){

        return ResponseEntity.ok(followService.followUser(getLoginedUser().getId(),followId));
    }
 }
