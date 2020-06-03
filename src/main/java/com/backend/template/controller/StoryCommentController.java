package com.backend.template.controller;

import com.backend.template.dto.input.UpdateStoryComment;
import com.backend.template.model.StoryComment;
import com.backend.template.model.response.ResponseFactory;
import com.backend.template.service.StoryCommentService;
import com.backend.template.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/story-comments")
public class StoryCommentController extends BaseController{

    @Autowired
    private ResponseFactory responseFactory;

    @Autowired
    StoryCommentService storyCommentService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllStoryComments(@RequestParam(defaultValue = "0", required = false) Integer page,
                                                 @RequestParam(defaultValue = "10", required = false) Integer size,
                                                 @RequestParam(defaultValue = "id", required = false) String sort) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Utils.getOrderFieldsOfRequest(sort)));
        return responseFactory.success(storyCommentService.getAllStoryComments(pageable));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getStoryComment(@PathVariable String id) {
        return responseFactory.success(storyCommentService.getStoryComment(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStoryComment(@Valid @RequestBody StoryComment storyComment) {
        storyComment.setUserId(getLoginedUser().getId());
        return responseFactory.success(storyCommentService.createStoryComment(storyComment));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStoryComment(@Valid @RequestBody UpdateStoryComment updateStoryComment, @PathVariable String id) {
        return responseFactory.success(storyCommentService.updateStoryComment(updateStoryComment, id));
    }
}
