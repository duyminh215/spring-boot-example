package com.backend.template.controller;

import com.backend.template.dto.input.UpdateStoryComment;
import com.backend.template.model.StoryComment;
import com.backend.template.model.response.ResponseFactory;
import com.backend.template.service.StoryCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/story-comments")
public class StoryCommentController {

    @Autowired
    private ResponseFactory responseFactory;

    @Autowired
    StoryCommentService storyCommentService;

    @GetMapping("")
    public ResponseEntity<?> getAllStoryComments(@RequestParam(defaultValue = "0", required = false) Integer page,
                                                 @RequestParam(defaultValue = "10", required = false) Integer size,
                                                 @RequestParam(defaultValue = "id", required = false) String sort) {
        return responseFactory.success(storyCommentService.getAllStoryComments(page, size, sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStoryComment(@PathVariable String id) {
        return responseFactory.success(storyCommentService.getStoryComment(id));
    }

    @PostMapping("")
    public ResponseEntity<?> createStoryComment(@Valid @RequestBody StoryComment storyComment) {
        return responseFactory.success(storyCommentService.createStoryComment(storyComment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStoryComment(@Valid @RequestBody UpdateStoryComment updateStoryComment, @PathVariable String id) {
        return responseFactory.success(storyCommentService.updateStoryComment(updateStoryComment, id));
    }
}
