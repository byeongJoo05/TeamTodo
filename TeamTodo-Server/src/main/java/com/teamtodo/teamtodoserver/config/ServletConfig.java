package com.teamtodo.teamtodoserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* 추후 파라미터 타입 변환을 위해 사용할 예정입니다.*/
@Configuration
@EnableWebMvc
public class ServletConfig implements WebMvcConfigurer {
}
