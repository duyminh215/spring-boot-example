package com.backend.template.controller;

import com.backend.template.repositories.FollowingRepository;
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
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    private FollowService followService;
    @GetMapping("/get-following-user-list")
    public ResponseEntity<?> getFollowingUserList(){
        return ResponseEntity.ok(followService.getFollowingUserList());
    }
    @GetMapping("/get-follower")
    public ResponseEntity<?> getFollowerList(){
        return ResponseEntity.ok(followService.getFollower());
    }

    @PostMapping()
    public ResponseEntity<?> followUser(@RequestParam("followid")long followId){
        return ResponseEntity.ok(followService.followUser(followId));
    }
 }
