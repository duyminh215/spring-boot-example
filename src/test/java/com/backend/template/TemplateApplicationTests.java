package com.backend.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EntityScan("com.backend.template.model")
@EnableAutoConfiguration()
@EnableCaching
@PropertySource("classpath:application.properties")
public class TemplateApplicationTests {

    @Test
    public void contextLoads() {
    }
}
