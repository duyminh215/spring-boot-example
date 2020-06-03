package com.backend.template.service;

import com.backend.template.dto.input.UpdateStoryComment;
import com.backend.template.model.StoryComment;
import com.backend.template.paging.PagingInfo;
import com.backend.template.repositories.StoryCommentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StoryCommentServiceTest {

    @Mock
    private StoryCommentRepository storyCommentRepository;

    @InjectMocks
    private StoryCommentService storyCommentService;

    private List<StoryComment> storyCommentList;

    private StoryComment storyComment;

    private UpdateStoryComment updateStoryComment;

    @Before
    public void setUp() throws Exception {
        storyCommentList = new ArrayList<>();
        storyCommentList.add(new StoryComment("1", 1224146L, "Hello", 1, 1L, 1L));
        storyCommentList.add(new StoryComment("2", 1222654L, "Goodbye", 1, 1L, 1L));
        storyCommentList.add(new StoryComment("3", 6655433L, "Love you", 1, 1L, 1L));
        storyCommentList.add(new StoryComment("4", 3124233L, "I am Duong", 1, 1L, 1L));
        storyCommentList.add(new StoryComment("5", 1255445L, "How are you?", 1, 1L, 1L));

        storyComment = new StoryComment("6", 1224146L, "I'm fine", 1, 1L, 1L);
    }

    @Test
    public void getAllStoryComments() {
        Integer page = 0, size = 10;
        String sort = "id";
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<StoryComment> commentPage = new PageImpl<>(storyCommentList, pageable, storyCommentList.size());
        when(storyCommentRepository.findAll(pageable)).thenReturn(commentPage);
        PagingInfo<StoryComment> actual = storyCommentService.getAllStoryComments(page,size, sort);
        assertEquals(actual.getContents().size(), 5);
    }

    @Test
    public void getStoryComment() {
        when(storyCommentRepository.findById("1")).thenReturn(Optional.of(storyCommentList.get(0)));
        StoryComment actual = storyCommentService.getStoryComment("1");
        assertEquals(actual.getId(), "1");
    }

    @Test
    public void createStoryComment() {
        when(storyCommentRepository.save(storyComment)).thenReturn(storyComment);
        StoryComment actual = storyCommentService.createStoryComment(storyComment);
        assertEquals(storyComment.getId(), actual.getId());
    }

    @Test
    public void updateStoryComment() {
        updateStoryComment = new UpdateStoryComment("Xin chào", 1);
        StoryComment storyComment = new StoryComment("1", 1224146L, "Hello", 1, 1L, 1L);
        when(storyCommentRepository.findById("1")).thenReturn(Optional.of(storyComment));
        when(storyCommentRepository.save(storyComment)).thenReturn(storyComment);
        StoryComment actual = storyCommentService.updateStoryComment(updateStoryComment,"1");
        assertEquals(storyComment.getId(), actual.getId());
    }
}