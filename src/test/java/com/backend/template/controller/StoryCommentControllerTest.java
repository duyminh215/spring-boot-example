package com.backend.template.controller;

import com.backend.template.dto.input.CreateStoryComment;
import com.backend.template.dto.input.UpdateStoryComment;
import com.backend.template.dto.response.PageResponseBuilder;
import com.backend.template.model.StoryComment;
import com.backend.template.model.response.ResponseFactory;
import com.backend.template.service.StoryCommentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StoryCommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StoryCommentService storyCommentService;

    @Mock
    private ResponseFactory responseFactory;

    @InjectMocks
    StoryCommentController storyCommentController;

    private String accessToken;

    private StoryComment storyComment;

    private List<StoryComment> storyCommentList;

    @Before
    public void setUp() throws Exception {
        storyCommentList = new ArrayList<>();
        storyCommentList.add(new StoryComment("1", 1224146L, "Hello", 1, 1L, 1L));
        storyCommentList.add(new StoryComment("2", 1222654L, "Goodbye", 1, 1L, 1L));
        storyCommentList.add(new StoryComment("3", 6655433L, "Love you", 1, 1L, 1L));
        storyCommentList.add(new StoryComment("4", 3124233L, "I am Duong", 1, 1L, 1L));
        storyCommentList.add(new StoryComment("5", 1255445L, "How are you?", 1, 1L, 1L));

        accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiMSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU5MTI2NzI1NSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiI3NGM4OTIyYS02ODg2LTRmM2UtYjEwZS00ZThkZWYzNGU0NTIiLCJjbGllbnRfaWQiOiJkZXZnbGFuLWNsaWVudCJ9.2-Y3sYGCzp62NgAdGwjp7iAomtWcF8nPeAsPFLstInM";
        storyComment = new StoryComment("1", 1224146L, "I'm fine", 1, 1L, 1L);
    }

    @Test
    public void getAllStoryComments() throws Exception {
        Integer page = 0;
        Integer size = 10;
        String sort = "id";
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<StoryComment> storyComments = new PageImpl<>(storyCommentList, pageable, storyCommentList.size());

        when(storyCommentService.getAllStoryComments(pageable)).thenReturn(PageResponseBuilder.buildPagingData(storyComments, pageable));

        this.mockMvc.perform(
                get("/story-comments")
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .requestAttr("page", 0).requestAttr("size", 10).requestAttr("sort", "id"))
                .andExpect(status().isOk());
    }

    @Test
    public void getStoryComment() throws Exception {
        String id = "1";
        when(storyCommentService.getStoryComment(id)).thenReturn(storyComment);

        this.mockMvc.perform(
                get("/story-comments/detail/{id}", id)
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createStoryComment() throws Exception {
        CreateStoryComment createStoryComment = new CreateStoryComment("I'm fine", 1, 1L);
        when(storyCommentService.createStoryComment(createStoryComment, 1L)).thenReturn(storyComment);

        String json = "{\"content\":\"I love you\",\"status\":\"1\",\"storyId\":\"2\"}";
        this.mockMvc.perform(
                post("/story-comments/create")
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void updateStoryComment() throws Exception {
        UpdateStoryComment updateStoryComment = new UpdateStoryComment("1", "I'm fine", 1);
        when(storyCommentService.updateStoryComment(updateStoryComment, 1L)).thenReturn(storyComment);

        String json = "{\"id\":\"1\",\"content\":\"I'm fine\",\"status\":\"1\"}";

        this.mockMvc.perform(
                put("/story-comments/update")
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }
}