package com.backend.template.dto.output;

import com.backend.template.model.UserStory;

public class CreateStoryDto {
	private UserStory userStory;
	
	public CreateStoryDto() {
	}
	public CreateStoryDto(long id) {
		this.id = id;
	}
	private long id;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserStory getUserStory() {
		return userStory;
	}
	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}
}
