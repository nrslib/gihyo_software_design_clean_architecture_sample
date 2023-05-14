package com.nrslib.cleanimpl.service.app.application.domain.models.sample;

import java.util.Optional;

public interface SampleRepository {
    void save(Sample sample);

    Optional<Sample> find(SampleId sampleId);
}
