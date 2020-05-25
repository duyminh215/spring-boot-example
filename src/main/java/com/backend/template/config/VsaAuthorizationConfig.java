package com.backend.template.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "authorization")
public class VsaAuthorizationConfig {
    private String clientId;

    private String clientSecret;

    private String apiHostName;

    private String accessTokenUrl;

    private String refreshTokenUrl;

    private int mintMaxRequest;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getApiHostName() {
        return apiHostName;
    }

    public void setApiHostName(String apiHostName) {
        this.apiHostName = apiHostName;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getRefreshTokenUrl() {
        return refreshTokenUrl;
    }

    public void setRefreshTokenUrl(String refreshTokenUrl) {
        this.refreshTokenUrl = refreshTokenUrl;
    }

    public int getMintMaxRequest() {
        return mintMaxRequest;
    }

    public void setMintMaxRequest(int mintMaxRequest) {
        this.mintMaxRequest = mintMaxRequest;
    }
}
