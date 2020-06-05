package com.backend.template.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
////@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest(UserNotificationController.class)
class UserNotificationControllerTest {
    @Autowired
    private MockMvc mockMvc;

//    @BeforeEach
//    void setUp() {
//    }

    @Test
    void getAllNotice() throws Exception {
        mockMvc.perform(get("/userNotice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiMiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU5MTMzMTUwOSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiIyMzNmMWYyZC0wMTIzLTRmYWMtYjAzYi01MGIwZWY3N2JmOTIiLCJjbGllbnRfaWQiOiJkZXZnbGFuLWNsaWVudCJ9.XkBjULiIPGo55VVH3AN8ObGj6X9C22P9bAT0d848DMw")
                        .header("Accept-Language", "vi")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sort", "\"\""))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}