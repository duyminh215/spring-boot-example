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
    @GetMapping("/get-following-user-list/{id}")
    public ResponseEntity<?> getFollowingUserList(@PathVariable int id){
        return ResponseEntity.ok(followService.getFollowingUserList(id));
    }
    @GetMapping("/get-follower/{id}")
    public ResponseEntity<?> getFollowerList(@PathVariable int id){
        return ResponseEntity.ok(followService.getFollower(id));
    }
    @PostMapping("")
    public ResponseEntity<?> followUser(@RequestParam("userid") int userid , @RequestParam("followinguserid") int followinguserid
    ){
                
        return null;
    }
 }