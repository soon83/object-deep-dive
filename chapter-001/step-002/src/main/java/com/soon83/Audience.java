package com.soon83;

import lombok.ToString;

/**
 * 관람객
 */
@ToString
public class Audience {
    private final Bag bag;

    /**
     * 관람객은 가방 필수
     */
    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            /**
             * 조건: 관람객에게 초대장이 있다면
             * 1. 관람객이 티켓을 받아 가방에 넣는다
             * 2. 티켓요금을 지불한다. (티켓요금은 0 원)
             */
            bag.setTicket(ticket);
            return 0L;
        } else {
            /**
             * 조건: 관람객에게 초대장이 없다면
             * 1. 관람객이 티켓을 받아 가방에 넣는다
             * 2. 관램객이 가방에서 티켓요금을 꺼낸다
             * 3. 티켓요금을 지불한다.
             */
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}
