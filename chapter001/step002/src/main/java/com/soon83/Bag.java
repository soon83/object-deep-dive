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

    public boolean hasInvitation() {
        return invitation != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

}
