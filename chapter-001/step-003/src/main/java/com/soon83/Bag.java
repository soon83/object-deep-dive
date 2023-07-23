package com.soon83;

import lombok.ToString;

/**
 * 가방 (of 관람객)
 */
@ToString
public class Bag {
    private Long amount; // 현금
    private final Invitation invitation; // 초대장
    private Ticket ticket; // 티켓

    /**
     * 가방안에 현금만 있는 경우
     */
    public Bag(Long amount) {
        this(null, amount);
    }

    /**
     * 가방안에 현금과 초대장이 있는 경우
     */
    public Bag(Invitation invitation, Long amount) {
        this.amount = amount;
        this.invitation = invitation;
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            /**
             * 조건: 관람객에게 초대장이 있다면
             * 1. 관람객으로부터 티켓을 받는다.
             * 2. 티켓요금을 지불한다. (초대장이 있으므로 티켓요금은 0 원)
             */
            setTicket(ticket);
            return 0L;
        } else {
            /**
             * 조건: 관람객에게 초대장이 없다면
             * 1. 관람객으로부터 티켓을 받는다.
             * 2. 가진 현금에서 티켓요금을 뺀다.
             * 3. 티켓요금을 지불한다.
             */
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

}
