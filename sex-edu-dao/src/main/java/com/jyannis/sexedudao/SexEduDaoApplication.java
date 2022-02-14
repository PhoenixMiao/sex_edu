package com.jyannis.sexedudao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.jyannis.sexedudao.mapper")
@ComponentScan(basePackages = {"com.jyannis"})
public class SexEduDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SexEduDaoApplication.class, args);
	}

}
