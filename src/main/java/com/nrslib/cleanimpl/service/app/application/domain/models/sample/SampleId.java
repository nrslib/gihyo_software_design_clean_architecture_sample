package com.nrslib.cleanimpl.service.app.application.domain.models.sample;

import java.util.UUID;

public record SampleId(UUID value) {
    public SampleId() {
        this(UUID.randomUUID());
    }
}
