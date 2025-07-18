package com.reitansora.auth.entity;

import lombok.Getter;

@Getter
public enum StreamingQuality {
    NONE(0L),
    HD(4_000_000L),
    FHD(8_000_000L),
    UHD(15_600_000L);

    private final long maxBitrate;

    StreamingQuality(long maxBitrate) {
        this.maxBitrate = maxBitrate;
    }
}
