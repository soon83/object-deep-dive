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

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    /**
     * 트레이드오프 포인트
     * TicketOffice 의 자율성은 만족했지만, Audience 의 의존성이 생겼다.
     * step-002 로 설계를 되돌린다.
     */
    public void sellTicketTo(Audience audience) {
        Long ticketFee = audience.buy(getTicket());
        plusAmount(ticketFee);
    }
}
