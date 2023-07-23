package com.soon83;

import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 초대장
 */
@ToString
public class Invitation {
    private LocalDateTime when; // 초대일자

    public Invitation(LocalDateTime when) {
        this.when = when;
    }
}
