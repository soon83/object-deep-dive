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
        // Bag 클래스의 hole 메서드로 로직을 옮긴다.
        return bag.hold(ticket);
    }
}
