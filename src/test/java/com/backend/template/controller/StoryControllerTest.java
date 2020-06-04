package com.backend.template.controller;

import com.backend.template.dto.UserBasicInfoDto;
import com.backend.template.dto.input.CreateStoryInput;
import com.backend.template.dto.output.CreateStoryDto;
import com.backend.template.dto.response.PageResponseBuilder;
import com.backend.template.model.UserStory;
import com.backend.template.service.StoryService;
import com.google.gson.Gson;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class StoryControllerTest extends TestCase {


    @MockBean
    private StoryService storyService;

    @InjectMocks
    private StoryController storyController;

    private UserStory userStory;

    @Autowired
    private MockMvc mockMvc;

    private String accessToken;

    @Before
    public void setUp() {
    }

    @Test
    public void createStory() throws Exception {
        userStory = new UserStory(1L, " String title", " String content", 1);
        accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiMSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU5MTI1OTAyOSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiIwMWFiN2Q5Yy0zNjQ0LTRkMTctYmU1MC1iNjAyZjYxN2E5ZjgiLCJjbGllbnRfaWQiOiJkZXZnbGFuLWNsaWVudCJ9.CpOV1cFP9H6iYUSIhxgwXvsWUHObRfQpc6qEAGQvVO8";
        UserBasicInfoDto userBasicInfoDto = new UserBasicInfoDto();
        userBasicInfoDto.setUserId(1L);
        CreateStoryInput createStoryInput = new CreateStoryInput(" String title", " String content", 1);
        CreateStoryDto createStoryDto = new CreateStoryDto();
        createStoryDto.setId(1L);
        createStoryDto.setUserStory(userStory);
        when(storyService.createStory(userBasicInfoDto, createStoryInput)).thenReturn(createStoryDto);

        Gson gson = new Gson();
        String json = gson.toJson(createStoryInput);

        this.mockMvc.perform(
                post("/api/story")
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

    }

    @Test
    public void updateStory() throws Exception {
        userStory = new UserStory(1L, " String title", " String content", 1);
        userStory.setId(1L);
        accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiMSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU5MTI1OTAyOSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiIwMWFiN2Q5Yy0zNjQ0LTRkMTctYmU1MC1iNjAyZjYxN2E5ZjgiLCJjbGllbnRfaWQiOiJkZXZnbGFuLWNsaWVudCJ9.CpOV1cFP9H6iYUSIhxgwXvsWUHObRfQpc6qEAGQvVO8";
        UserBasicInfoDto userBasicInfoDto = new UserBasicInfoDto();
        userBasicInfoDto.setUserId(1L);
        CreateStoryInput createStoryInput = new CreateStoryInput(" String title", " String content", 1);
        CreateStoryDto createStoryDto = new CreateStoryDto();
        createStoryDto.setId(1L);
        createStoryDto.setUserStory(userStory);
        when(storyService.updateStory(userBasicInfoDto, createStoryInput,userStory.getId())).thenReturn(createStoryDto);

        Gson gson = new Gson();
        String json = gson.toJson(createStoryInput);

        this.mockMvc.perform(
                put("/api/story/{id}",userStory.getId())
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void getPageStory() throws Exception {
        accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiMSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU5MTI1OTAyOSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiIwMWFiN2Q5Yy0zNjQ0LTRkMTctYmU1MC1iNjAyZjYxN2E5ZjgiLCJjbGllbnRfaWQiOiJkZXZnbGFuLWNsaWVudCJ9.CpOV1cFP9H6iYUSIhxgwXvsWUHObRfQpc6qEAGQvVO8";
        Long userId=1L;
        Integer page =0;
        Integer size=10;

        Pageable p = PageRequest.of(page, size);
        List<UserStory> list = new ArrayList<>();
        list.add(new UserStory(1L, " String title", " String content", 1));
        list.add(new UserStory(1L, " String title", " String content", 1));
        list.add(new UserStory(1L, " String title", " String content", 1));
        Page<UserStory> pagination = new PageImpl<>(list, p, list.size());
        when(storyService.getPageStory(userId,p)).thenReturn(PageResponseBuilder.buildPagingData(pagination, p));


        this.mockMvc.perform(

                get("/api/story")
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON)
                        .requestAttr("page", 0).requestAttr("size",1))
                .andExpect(status().isOk());

    }

    @Test
    public void getDetail() throws Exception {
        accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiMSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU5MTI1OTAyOSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiIwMWFiN2Q5Yy0zNjQ0LTRkMTctYmU1MC1iNjAyZjYxN2E5ZjgiLCJjbGllbnRfaWQiOiJkZXZnbGFuLWNsaWVudCJ9.CpOV1cFP9H6iYUSIhxgwXvsWUHObRfQpc6qEAGQvVO8";

        Long storyId=1L;
        userStory = new UserStory(1L, " String title", " String content", 1);
        when(storyService.getStoryDetail(storyId,userStory.getUserId())).thenReturn(Optional.of(userStory));

        this.mockMvc.perform(
                get("/api/story/{id}",storyId)
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}