package com.soon83;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class Step001Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Step001Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    @Bean
    @EventListener(Step001Application.class)
    public void eventListener() {
        // TODO
    }

}
