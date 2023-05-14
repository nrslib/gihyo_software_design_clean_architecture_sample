package com.nrslib.cleanimpl.service.app.application.usecases.typical.interactors;

import com.nrslib.cleanimpl.service.app.application.domain.models.sample.Sample;
import com.nrslib.cleanimpl.service.app.application.domain.models.sample.SampleId;
import com.nrslib.cleanimpl.service.app.application.domain.models.sample.SampleRepository;
import com.nrslib.cleanimpl.service.app.application.usecases.typical.inputboundary.TypicalCreateInputBoundary;
import com.nrslib.cleanimpl.service.app.application.usecases.typical.inputboundary.TypicalCreateInputData;
import com.nrslib.cleanimpl.service.app.application.usecases.typical.outputboundary.TypicalCreateOutputBoundary;
import com.nrslib.cleanimpl.service.app.application.usecases.typical.outputboundary.TypicalCreateOutputData;

public class TypicalCreateInteractor implements TypicalCreateInputBoundary {
    private final SampleRepository sampleRepository;
    private final TypicalCreateOutputBoundary outputPort;

    public TypicalCreateInteractor(SampleRepository sampleRepository, TypicalCreateOutputBoundary outputPort) {
        this.sampleRepository = sampleRepository;
        this.outputPort = outputPort;
    }

    @Override
    public void handle(TypicalCreateInputData inputData) {
        var sample = new Sample(
                new SampleId(),
                inputData.data());
        sampleRepository.save(sample);

        outputPort.handle(new TypicalCreateOutputData(sample.getSampleId().value(), sample.getData()));
    }
}
