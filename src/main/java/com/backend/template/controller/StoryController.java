package com.backend.template.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.template.dto.input.CreateStoryInput;
import com.backend.template.model.response.ResponseFactory;
import com.backend.template.service.StoryService;
import com.backend.template.validators.StoryValidator;

@RestController
@RequestMapping("/api")
public class StoryController extends BaseController{
	
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
}