package com.backend.template.config;

import java.util.logging.Logger;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
@Slf4j
@Getter
@RefreshScope
public class AsyncConfig {

    Logger log = Logger.getLogger(AsyncConfig.class.getName());

    @Value("${executor.corePoolSize}")
    private String poolSize;
    @Value("${executor.maxPoolSize}")
    private String setMaxPoolSize;

    @Bean("threadPoolTaskExecutor")
    public TaskExecutor getAsyncExecutor() {
        log.info("corePoolSize : " + poolSize + "\nMaxPoolSize : " + setMaxPoolSize);
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Integer.parseInt(poolSize));
        executor.setMaxPoolSize(Integer.parseInt(setMaxPoolSize));
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("Async-");
        return executor;
    }

    public String getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(String poolSize) {
        this.poolSize = poolSize;
    }

    public String getSetMaxPoolSize() {
        return setMaxPoolSize;
    }

    public void setSetMaxPoolSize(String setMaxPoolSize) {
        this.setMaxPoolSize = setMaxPoolSize;
    }
}
