package com.teamtodo.teamtodoserver.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@EnableWebSecurity // 스프링 시큐리티 사용을 위한 어노테이션
@EnableMethodSecurity // 메소드 시큐리티. 메소드 호출 이전 권한 확인이 가능
@RequiredArgsConstructor
public class SecurityConfig {

	/*
	 * 비밀번호를 BCrypt 형식으로 변환해주기 위한 Bean
	 * */
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring()
			.requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf)->csrf.disable()); //CSRF 토큰 비활성화
		http.sessionManagement((sessionManagement)->sessionManagement
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //세션 사용 안함
		return http.build();
	}
}
