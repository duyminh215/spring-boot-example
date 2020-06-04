package com.backend.template.controller;

import com.backend.template.dto.input.CreateStoryComment;
import com.backend.template.model.StoryComment;
import com.backend.template.model.response.ResponseFactory;
import com.backend.template.service.StoryCommentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class StoryCommentControllerTest {

    private MockMvc mockMvc;

    @MockBean
    StoryCommentService storyCommentService;

    @Mock
    private ResponseFactory responseFactory;

    @InjectMocks
    StoryCommentController storyCommentController;

    private String accessToken;

    private StoryComment storyComment;

    @Before
    public void setUp() throws Exception {
        storyComment = new StoryComment("1", 1224146L, "I'm fine", 1, 1L, 1L);
    }

    @Test
    public void getAllStoryComments() {
    }

    @Test
    public void getStoryComment() {
    }

    @Test
    public void createStoryComment() throws Exception {
        CreateStoryComment createStoryComment = new CreateStoryComment("I'm fine", 1, 1L);
        accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiMSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU5MTI1OTAyOSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiIwMWFiN2Q5Yy0zNjQ0LTRkMTctYmU1MC1iNjAyZjYxN2E5ZjgiLCJjbGllbnRfaWQiOiJkZXZnbGFuLWNsaWVudCJ9.CpOV1cFP9H6iYUSIhxgwXvsWUHObRfQpc6qEAGQvVO8";

        when(storyCommentService.createStoryComment(any(CreateStoryComment.class))).thenReturn(storyComment);

        String json = "{\"content\":\"I love you\",\"status\":\"1\",\"storyId\":\"2\"}";
        this.mockMvc.perform(
                post("/story-comments/create")
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void updateStoryComment() {
    }
}