package com.gymManage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GymManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymManageApplication.class, args);

	}


}
