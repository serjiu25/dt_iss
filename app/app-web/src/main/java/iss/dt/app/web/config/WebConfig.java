package iss.dt.app.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({"iss.dt.app.web.controller", "iss.dt.app.web.converter"})
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedHeaders("*")
                        .allowedOrigins("http://localhost:4200", "http://localhost:8080",
                                        "http://192.168.1.4:4200")
                        .allowedMethods("GET", "PUT", "PATCH", "POST", "DELETE", "OPTIONS")
                        .allowCredentials(true)
                        .exposedHeaders("Access-Control-Allow-Origin:*")
                        .maxAge(9600);
            }
        };
    }
}
