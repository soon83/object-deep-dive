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
        if (audience.getBag().hasInvitation()) {
            /**
             * 조건: 관람객에게 초대장이 있다면
             * 1. 티켓 판매원이 티켓 판매소에서 티켓을 가져옴
             * 2. 관람객의 가방에 티켓을 넣는다
             */
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            /**
             * 조건: 관람객에게 초대장이 없다면
             * 1. 티켓 판매원이 티켓 판매소에서 티켓을 가져옴
             * 2. 관람객의 가방에서 티켓 요금을 뺀다
             * 3. 관람객의 가방에서 꺼낸 티켓 요금을 티켓 판매소에 넣는다
             * 4. 관람객의 가방에 티켓을 넣는다
             */
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
