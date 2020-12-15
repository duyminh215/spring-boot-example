package com.backend.template.service;

//import com.sun.tools.doclint.Entity;

import com.backend.template.dto.response.PageResponseBuilder;
import com.backend.template.paging.PagingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.template.constant.ErrorMessage;
import com.backend.template.dto.UserBasicInfoDto;
import com.backend.template.dto.input.CreateStoryInput;
import com.backend.template.dto.output.CreateStoryDto;
import com.backend.template.exception.ServerException;
import com.backend.template.model.UserStory;
import com.backend.template.repositories.UserStoryRepository;

import java.util.Optional;

@Service
public class StoryService {

    @Autowired
    UserStoryRepository userStoryRepository;

    public CreateStoryDto createStory(UserBasicInfoDto userBasicInfoDto, CreateStoryInput createStoryInput) {
        UserStory userStory = createInstanceUserStory(userBasicInfoDto, createStoryInput);
        userStoryRepository.save(userStory);
        return generateUserStoryResponse(userStory);
    }

    private UserStory createInstanceUserStory(UserBasicInfoDto userBasicInfoDto, CreateStoryInput input) {
        long userId = userBasicInfoDto.getUserId();
        String title = input.getTitle();
        String content = input.getContent();
        int privacyStatus = input.getPrivacyStatus();
        UserStory userStory = new UserStory(userId, title, content, privacyStatus);
        return userStory;
    }

    private CreateStoryDto generateUserStoryResponse(UserStory userStory) {
        CreateStoryDto createStoryDto = new CreateStoryDto();
        createStoryDto.setUserStory(userStory);
        createStoryDto.setId(userStory.getId());
        return createStoryDto;
    }

    public CreateStoryDto updateStory(UserBasicInfoDto userBasicInfoDto, CreateStoryInput createStoryInput, long id)
            throws ServerException {
        long userId = userBasicInfoDto.getUserId();
        UserStory userStory = userStoryRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorMessage.USER_NOT_FOUND));
        validateData(userStory, userId);
        userStory = changeStateUserStory(userStory, createStoryInput);
        userStoryRepository.save(userStory);
        return generateUserStoryResponse(userStory);
    }

    private void validateData(UserStory userStory, long userId) {
        if (userStory == null) {
            throw new ServerException(ErrorMessage.PROVIDER_NOT_FOUND);
        }
        if (userStory.getUserId() != userId) {
            throw new ServerException(ErrorMessage.INVALID_AUTHORIZED);
        }
    }

    private UserStory changeStateUserStory(UserStory userStory, CreateStoryInput input) {
        userStory.setTitle(input.getTitle());
        userStory.setContent(input.getContent());
        userStory.setPrivacyStatus(input.getPrivacyStatus());
        return userStory;
    }

    public PagingInfo getPageStory(Long userId, Pageable p) {

        return PageResponseBuilder.buildPagingData(userStoryRepository.getPageStoryByUser(userId, p), p);
    }

    public Optional<UserStory> getStoryDetail(Long storyId, Long userId){

        return Optional.of(userStoryRepository.getStoryDetail(storyId, userId));
    }
}
