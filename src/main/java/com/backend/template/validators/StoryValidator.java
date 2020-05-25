package com.backend.template.validators;

import org.springframework.stereotype.Component;

import com.backend.template.dto.input.CreateStoryInput;
import com.backend.template.exception.RequestInvalidException;
import com.backend.template.locale.Translator;

@Component
public class StoryValidator {

	public void validateCreateStory(CreateStoryInput createStoryInput) {
		if(createStoryInput.getTitle() == null || createStoryInput.getTitle().trim().isEmpty()) {
			throw new RequestInvalidException(Translator.toLocale("error.msg.create_story_title_empty"));
		}
		if(createStoryInput.getContent() == null || createStoryInput.getContent().trim().isEmpty()) {
			throw new RequestInvalidException(Translator.toLocale("error.msg.create_story_content_empty"));
		}
	}
}
