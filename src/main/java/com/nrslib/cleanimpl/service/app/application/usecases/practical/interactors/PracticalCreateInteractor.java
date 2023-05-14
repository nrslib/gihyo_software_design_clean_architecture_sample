package com.nrslib.cleanimpl.service.app.application.usecases.practical.interactors;

import com.nrslib.cleanimpl.service.app.application.domain.models.sample.Sample;
import com.nrslib.cleanimpl.service.app.application.domain.models.sample.SampleId;
import com.nrslib.cleanimpl.service.app.application.domain.models.sample.SampleRepository;
import com.nrslib.cleanimpl.service.app.application.usecases.practical.inputboundary.PracticalCreateInputBoundary;
import com.nrslib.cleanimpl.service.app.application.usecases.practical.inputboundary.PracticalCreateInputData;
import com.nrslib.cleanimpl.service.app.application.usecases.practical.outputboundary.PracticalCreateOutputData;

public class PracticalCreateInteractor implements PracticalCreateInputBoundary {
    private final SampleRepository sampleRepository;

    public PracticalCreateInteractor(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public PracticalCreateOutputData handle(PracticalCreateInputData inputData) {
        var sample = new Sample(
                new SampleId(),
                inputData.data());
        sampleRepository.save(sample);

        return new PracticalCreateOutputData(sample.getSampleId().value(), sample.getData());
    }
}
