package com.soon83;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 티켓 판매소
 */
@ToString
public class TicketOffice {
    private Long amount;
    private final List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
