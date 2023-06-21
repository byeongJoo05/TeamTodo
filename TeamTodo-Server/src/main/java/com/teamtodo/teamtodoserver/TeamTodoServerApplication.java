package com.teamtodo.teamtodoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TeamTodoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamTodoServerApplication.class, args);
	}

}
