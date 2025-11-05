package com.ib.book.config; // 프로젝트 패키지에 맞게 수정

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 웹 보안 활성화
public class SecurityConfig {

    // Swagger UI 및 API 문서 관련 URL 패턴 정의
    private static final String[] SWAGGER_URL_WHITELIST = {
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-resources",
            "/webjars/**",
    };

    // 테스트 목적으로 임시로 추가
    private static final String[] API_WHITELIST = {
            "v1/member/list",       // GET /member/list 허용
            "/api/member/list",   // 혹시 API 경로가 /api로 시작한다면 이것도 추가
            // ... 다른 임시 허용할 API 경로 ...
    };


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                // Swagger UI 관련 URL들은 인증 없이 접근 허용
                .requestMatchers(SWAGGER_URL_WHITELIST).permitAll()
                // ⭐️ 추가: member/list 등 특정 API도 인증 없이 접근 허용
                .requestMatchers(API_WHITELIST).permitAll()
                // 그 외 모든 요청은 인증 필요
                .anyRequest().authenticated()
            );

        return http.build();
    }

}