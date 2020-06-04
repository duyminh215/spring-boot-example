package com.backend.template.controller;

import com.backend.template.exception.StoryNotBelongUserException;
import com.backend.template.locale.Translator;
import com.backend.template.model.UserStory;
import com.backend.template.paging.PagingInfo;
import com.backend.template.repositories.UserStoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.backend.template.dto.input.CreateStoryInput;
import com.backend.template.model.response.ResponseFactory;
import com.backend.template.service.StoryService;
import com.backend.template.validators.StoryValidator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated

public class StoryController extends BaseController {

    private static final Logger logger = LogManager.getLogger(StoryController.class);

    @Autowired
    private ResponseFactory responseFactory;

    @Autowired
    StoryService storyService;

    @Autowired
    StoryValidator storyValidator;

    @PostMapping("/story")
    public ResponseEntity<?> createStory(@RequestBody CreateStoryInput createStoryInput) {
        storyValidator.validateCreateStory(createStoryInput);
        return responseFactory.success(storyService.createStory(getUserBasicInfo(), createStoryInput));
    }

    @PutMapping("/story/{id}")
    public ResponseEntity<?> updateStory(@RequestBody CreateStoryInput createStoryInput, @PathVariable Long id) {
        storyValidator.validateCreateStory(createStoryInput);
        return responseFactory.success(storyService.updateStory(getUserBasicInfo(), createStoryInput, id));
    }

    @GetMapping("/story")
    public ResponseEntity<?> getPageStory(@RequestParam(defaultValue ="0") @Min(value = 0) Integer page, @RequestParam(defaultValue = "10") @Min(1) @Max(10) Integer size) {

        Pageable p = PageRequest.of(page, size);
        return responseFactory.success(storyService.getPageStory(getLoginedUser().getId(),p));
    }

    @GetMapping("/story/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Long id){

        UserStory story = storyService.getStoryDetail(id,getLoginedUser().getId()).orElseThrow(() -> new StoryNotBelongUserException(Translator.toLocale("error.msg.story.not_belong_user")));
        return responseFactory.success( story);
    }
}