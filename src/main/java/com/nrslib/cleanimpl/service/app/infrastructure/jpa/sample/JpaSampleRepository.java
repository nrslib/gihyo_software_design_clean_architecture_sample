package com.nrslib.cleanimpl.service.app.infrastructure.jpa.sample;

import com.nrslib.cleanimpl.service.app.application.domain.models.sample.Sample;
import com.nrslib.cleanimpl.service.app.application.domain.models.sample.SampleId;
import com.nrslib.cleanimpl.service.app.application.domain.models.sample.SampleRepository;

import java.util.Optional;

public class JpaSampleRepository implements SampleRepository {
    private final SampleDataModelJpaRepository jpaRepository;

    public JpaSampleRepository(SampleDataModelJpaRepository jpaSampleRepository) {
        this.jpaRepository = jpaSampleRepository;
    }

    @Override
    public void save(Sample sample) {
        var dataModel = SampleDataModel.builder()
                .id(sample.getSampleId().value())
                .data(sample.getData())
                .build();

        jpaRepository.save(dataModel);
    }

    @Override
    public Optional<Sample> find(SampleId sampleId) {
        return jpaRepository.findById(sampleId.value())
                .map(dataModel ->
                        new Sample(
                                new SampleId(dataModel.getId()),
                                dataModel.getData()));
    }
}
