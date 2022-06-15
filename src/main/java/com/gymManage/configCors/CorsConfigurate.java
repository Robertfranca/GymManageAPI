package com.gymManage.configCors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class CorsConfigurate  implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry aluno) {
        aluno.addMapping("/api/aluno/{codigo}").allowedOrigins("http://localhost:3000").allowedMethods(
                "GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT"
        );
    }
}
