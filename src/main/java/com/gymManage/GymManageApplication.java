package com.gymManage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})//isso deixa o security inativo para desenvolver melhor
@EnableCaching
public class GymManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymManageApplication.class, args);

	}


}
