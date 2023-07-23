package com.soon83;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;

@Slf4j
@SpringBootApplication
public class Step002Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Step002Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    @Bean
    @EventListener(Step002Application.class)
    public void eventListener() {
        // 극장
        Ticket ticket1 = new Ticket(2000L);
        Ticket ticket2 = new Ticket(2000L);
        TicketOffice ticketOffice = new TicketOffice(0L, ticket1, ticket2);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);

        // 1. 초대장이 있는 관람객
        Invitation invitation = new Invitation(LocalDateTime.of(2023, 12, 31, 18, 0, 0));
        Bag bag1 = new Bag(invitation, 5000L);
        Audience audience1 = new Audience(bag1);
        theater.enter(audience1);
        log.debug("##### 초대장이 있는 관람객 #####");
        log.debug("# 1. audience1: {}", audience1);
        log.debug("# 1. theater: {}", theater);

        // 2. 초대장이 없는 관람객
        Bag bag2 = new Bag(5000L);
        Audience audience2 = new Audience(bag2);
        theater.enter(audience2);
        log.debug("##### 초대장이 없는 관람객 #####");
        log.debug("# 2. audience2: {}", audience2);
        log.debug("# 2. theater: {}", theater);
    }

}
