package com.teamtodo.teamtodoserver.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class MapperConfig {

	@Bean
	public ModelMapper getMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration() // 이전 생성한 ModelMapper 참조
			.setFieldMatchingEnabled(true) // 필드 매칭 활성화
			.setSkipNullEnabled(true)
			.setFieldAccessLevel(
				org.modelmapper.config.Configuration.AccessLevel.PRIVATE) // 필드 접근 수준을 PRIVATE수준도 가능하게끔 변경
			.setMethodAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
			.setMatchingStrategy(MatchingStrategies.LOOSE); // 필드 이름이 정확히 일치하지 않더라도 유사한 이름이면 매핑해줌
		return modelMapper;
	}
}
