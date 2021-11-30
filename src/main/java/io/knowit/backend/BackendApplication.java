package io.knowit.backend;

import io.knowit.backend.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * TODO: Add verbose exception handling...
 * TODO: Return list of errors for invalid requests...
 */
@EnableConfigurationProperties(AppProperties.class)
@SpringBootApplication
public class BackendApplication {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
