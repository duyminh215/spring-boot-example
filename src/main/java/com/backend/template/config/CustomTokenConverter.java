package com.backend.template.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.backend.template.dto.UserDetailCustomDto;

public class CustomTokenConverter extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        // TODO Auto-generated method stub
        accessToken = super.enhance(accessToken, authentication);
        UserDetailCustomDto userDetailCustomDto = (UserDetailCustomDto) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<String, Object>();
        additionalInfo.put("userId", userDetailCustomDto.getId());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }

}
