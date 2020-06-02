package com.backend.template.controller;

import com.backend.template.model.StoryComment;
import com.backend.template.service.StoryCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/story-comments")
public class StoryCommentController {
    @Autowired
    StoryCommentService storyCommentService;

    @GetMapping("")
    public ResponseEntity<?> getAllStoryComments(@RequestParam(required = false) Integer page,
                                                 @RequestParam(required = false) Integer size) {
        return ResponseEntity.ok(storyCommentService.getAllStoryComments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStoryComment(@PathVariable String id) {
        return ResponseEntity.ok(storyCommentService.getStoryComment(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createStoryComment(@RequestBody StoryComment comment){
        return ResponseEntity.ok(storyCommentService.createStoryComment(comment));
    }

    @PutMapping("")
    public ResponseEntity<?> updateStoryComment(@RequestBody StoryComment comment){
        return ResponseEntity.ok(storyCommentService.updateStoryComment(comment));
    }
}
