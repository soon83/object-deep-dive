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

    public Bag getBag() {
        return bag;
    }
}
