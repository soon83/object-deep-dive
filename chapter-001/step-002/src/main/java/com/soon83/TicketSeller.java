package com.soon83;

import lombok.ToString;

/**
 * 티켓 판매원
 */
@ToString
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        Long ticketFee = audience.buy(ticket);
        ticketOffice.plusAmount(ticketFee);
    }
}
