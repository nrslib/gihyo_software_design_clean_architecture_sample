package com.nrslib.cleanimpl.service.app.application.domain.models.sample;

import lombok.Getter;

@Getter
public class Sample {
    private final SampleId sampleId;
    private String data;

    public Sample(SampleId sampleId, String data) {
        this.sampleId = sampleId;
        this.data = data;
    }
}
