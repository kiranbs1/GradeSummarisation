package com.kiran.b.s.GradeSummarisation.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final ObjectMapper mapper;
    private final TokenStore tokenStore;
    private final TokenFilter tokenFilter;

    public SecurityConfig( ObjectMapper mapper, TokenStore tokenStore,
                           TokenFilter tokenFilter ) {
        this.mapper = mapper;
        this.tokenStore = tokenStore;
        this.tokenFilter = tokenFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.and())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/oauth2/**", "/login**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .authorizationEndpoint(authEndpoint -> authEndpoint
                                .authorizationRequestRepository(new InMemoryRequestRepository())
                        )
                        .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
                                .userService(customOAuth2UserService())
                        )
                        .successHandler(this::successHandler)
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint(this::authenticationEntryPoint)
                )
                .logout(logout -> logout
                        .addLogoutHandler(this::logout)
                        .logoutSuccessHandler(this::onLogoutSuccess)
                );

        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> customOAuth2UserService() {
        return new CustomOAuth2UserService();
    }

    private void logout(HttpServletRequest request, HttpServletResponse response,
                        Authentication authentication) {
        // You can process token here
        System.out.println("Auth token is - " + request.getHeader( "Authorization" ));
    }

    void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                         Authentication authentication) throws IOException, ServletException {
        // this code is just sending the 200 ok response and preventing redirect
        response.setStatus( HttpServletResponse.SC_OK );
    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedMethods( Collections.singletonList( "*" ) );
//        config.setAllowedOrigins( Collections.singletonList( "*" ) );
//        config.setAllowedHeaders( Collections.singletonList( "*" ) );
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration( "/**", config );
//        return source;
//    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedHeaders(Arrays.asList("authorization", "content-type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }


    private void successHandler( HttpServletRequest request,
                                 HttpServletResponse response, Authentication authentication ) throws IOException {
        String token = tokenStore.generateToken( authentication );
        response.getWriter().write(
                mapper.writeValueAsString( Collections.singletonMap( "accessToken", token ) )
        );
    }

    private void authenticationEntryPoint( HttpServletRequest request, HttpServletResponse response,
                                           AuthenticationException authException ) throws IOException {
        response.setStatus( HttpServletResponse.SC_UNAUTHORIZED );
        response.getWriter().write( mapper.writeValueAsString( Collections.singletonMap( "error", "Unauthenticated" ) ) );
    }
}
