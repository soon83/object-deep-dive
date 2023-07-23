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
        // TicketSeller 클래스의 sellTo 메서드로 로직을 옮긴다.
        ticketSeller.sellTo(audience);
    }
}
