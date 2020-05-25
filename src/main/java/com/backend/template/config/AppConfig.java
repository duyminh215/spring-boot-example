package com.backend.template.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@Getter
@Setter
@ConfigurationProperties("app")
public class AppConfig {

    @Value("${application-configuration}")
    String applicationConfiguration;

    @Value("${application-short-name}")
    String applicationShortName;

    public String getApplicationConfiguration() {
        return applicationConfiguration;
    }

    public void setApplicationConfiguration(String applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    public String getApplicationShortName() {
        return applicationShortName;
    }

    public void setApplicationShortName(String applicationShortName) {
        this.applicationShortName = applicationShortName;
    }
}
