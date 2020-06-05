package com.backend.template.controller;

import com.backend.template.exception.DuplicateException;
import com.backend.template.service.FollowService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
        when(followService.followUser(Mockito.anyLong(), Mockito.anyLong() )).thenThrow(duplicateException);
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/follower/following?followid=1")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiMSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU5MTM2MDEzNywiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiJjMWQwMzdjMi02YjYwLTRlOTEtYmQ5Mi01NDVkMGM0NTQ0MzEiLCJjbGllbnRfaWQiOiJkZXZnbGFuLWNsaWVudCJ9.nvurM9uDkrB3e9SDzmA9_TBu9Q6BGksTejHVv4ktqVs")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }
}
