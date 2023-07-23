package com.soon83;

import lombok.ToString;

/**
 * 극장
 */
@ToString
public class Theater {
    private final TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        // 로직을 TicketSeller.sellTo 메서드로 옮겼다.
        ticketSeller.sellTo(audience);
    }
}
