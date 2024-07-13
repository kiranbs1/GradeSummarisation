package com.kiran.b.s.GradeSummarisation.config;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.HashMap;
import java.util.Map;

public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // Extract the client registration ID
        String clientRegistrationId = userRequest.getClientRegistration().getRegistrationId();

        // Add client registration ID to the user's attributes
        Map<String, Object> attributes = new HashMap<>(oAuth2User.getAttributes());
        attributes.put("clientRegistrationId", clientRegistrationId);

        return new DefaultOAuth2User(oAuth2User.getAuthorities(), attributes, "name");
    }
}
