package com.backend.template.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserNotificationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllNotice() throws Exception {
        mockMvc.perform(get("/userNotice")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzb3VyY2VfaWQiXSwidXNlcl9uYW1lIjoiMiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSIsInRydXN0Il0sImV4cCI6MTU5MTM0ODAwMCwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiJjNjZlMmE0NS1mMTgzLTQxYTEtOTQ3NS0yYzMzOTgzZTQzMDkiLCJjbGllbnRfaWQiOiJkZXZnbGFuLWNsaWVudCJ9.9jhiGqTQIH-Fwlamq_Ib9QuqdE4M61AyHCFVmVJhYHA")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sort", ""))
                .andExpect(status().isOk());
    }
}