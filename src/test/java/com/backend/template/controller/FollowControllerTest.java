package com.backend.template.controller;

import com.backend.template.exception.DuplicateException;
import com.backend.template.service.FollowService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

/**
 * template
 *
 * @author longtcs
 * @created_at 05/06/2020 - 15:13
 * @created_by longtcs
 * @since 05/06/2020
 */
@SpringBootTest
@AutoConfigureMockMvc
public class FollowControllerTest  {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FollowService followService;

    @Test
    public void testFollowDuplicateId() throws Exception{
        DuplicateException duplicateException = new DuplicateException("Duplicate Id");
        when(followService.followUser(userid , followid).thenReturn(duplicateException);
        this.mockMvc.perform(
                get("/follower/following?followid=1", followid)
                        .header("Authorization", "Bearer " + this.accessToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
