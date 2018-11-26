package kz.iitu.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SushiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SushiApplication.class, args);
    }

}