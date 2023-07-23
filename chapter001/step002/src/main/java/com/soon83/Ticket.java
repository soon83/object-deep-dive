package com.soon83;

import lombok.ToString;

/**
 * 티켓
 */
@ToString
public class Ticket {
    private final Long fee; // 요금

    public Ticket(Long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }
}
