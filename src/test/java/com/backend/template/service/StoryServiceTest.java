package com.backend.template.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.backend.template.paging.PagingInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.util.ReflectionTestUtils;

import com.backend.template.dto.UserBasicInfoDto;
import com.backend.template.dto.input.CreateStoryInput;
import com.backend.template.dto.output.CreateStoryDto;
import com.backend.template.model.UserStory;
import com.backend.template.repositories.UserStoryRepository;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StoryServiceTest {
    @Mock
    private UserStoryRepository mockUserStoryRepository;
    @InjectMocks
    private StoryService storyService;

    @Test
    public void testSaveUserStory() {
        long expectedId = 4L;
        doAnswer(invocation -> {
            ReflectionTestUtils.setField((UserStory) invocation.getArgument(0), "id", expectedId);
            return null;
        }).when(mockUserStoryRepository).save(Mockito.any(UserStory.class));

        UserBasicInfoDto userBasicInfoDto = new UserBasicInfoDto();
        userBasicInfoDto.setUserId(1L);
        CreateStoryInput createStoryInput = new CreateStoryInput("Title", "content", 1);
        CreateStoryDto createStoryDto = storyService.createStory(userBasicInfoDto, createStoryInput);

        assertTrue(createStoryDto.getId() == expectedId);
    }

    @Test
    public void testUpdateStory() {
        long testId = 3l;
        doAnswer(invocation -> {
            UserStory userStory = new UserStory();
            userStory.setUserId(1L);
            userStory.setId(testId);
            userStory.setId(testId);
            Optional<UserStory> userStoryOptional = Optional.of(userStory);
            return userStoryOptional;
        }).when(mockUserStoryRepository).findById(testId);

        UserBasicInfoDto userBasicInfoDto = new UserBasicInfoDto();
        userBasicInfoDto.setUserId(1L);
        CreateStoryInput createStoryInput = new CreateStoryInput("Title", "content", 1);

        CreateStoryDto createStoryDto = storyService.updateStory(userBasicInfoDto, createStoryInput, testId);
        assertTrue(createStoryInput.getTitle().equals(createStoryDto.getUserStory().getTitle()));
        assertTrue(createStoryInput.getContent().equals(createStoryDto.getUserStory().getContent()));
        assertTrue(testId == createStoryDto.getId());
    }

    @Test
    public void testGetPageStory() {

        List<UserStory> list = new ArrayList<>();
        list.add(new UserStory(1L, " String title", " String content", 1));
        list.add(new UserStory(1L, " String title", " String content", 1));
        list.add(new UserStory(1L, " String title", " String content", 1));

        Long userId=1L;
        Integer page = 0;
        Integer size =10;

        Pageable p = PageRequest.of(page, size);
        Page<UserStory> pagination = new PageImpl<>(list, p, list.size());
        when(mockUserStoryRepository.getPageStoryByUser(userId, p)).thenReturn(pagination);

        PagingInfo actual = storyService.getPageStory(userId, p);
        assertEquals(actual.getContents(), list);
    }

    @Test
    public void testGetStoryDetail() {

        UserStory userStory = new UserStory(1L, " String title", " String content", 1);
        Long userId=1L;
        Long id=1L;
        when(mockUserStoryRepository.getStoryDetail(id, userId)).thenReturn(userStory);

        Optional<UserStory> optional = storyService.getStoryDetail(id, userId);

        assertEquals(optional.get(),userStory);


    }
}
