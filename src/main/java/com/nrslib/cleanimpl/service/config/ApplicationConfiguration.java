package com.nrslib.cleanimpl.service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nrslib.cleanimpl.service.app.application.domain.models.sample.SampleRepository;
import com.nrslib.cleanimpl.service.app.application.usecases.practical.inputboundary.PracticalCreateInputBoundary;
import com.nrslib.cleanimpl.service.app.application.usecases.practical.interactors.PracticalCreateInteractor;
import com.nrslib.cleanimpl.service.app.application.usecases.typical.inputboundary.TypicalCreateInputBoundary;
import com.nrslib.cleanimpl.service.app.application.usecases.typical.interactors.TypicalCreateInteractor;
import com.nrslib.cleanimpl.service.app.application.usecases.typical.outputboundary.TypicalCreateOutputBoundary;
import com.nrslib.cleanimpl.service.app.infrastructure.jpa.sample.JpaSampleRepository;
import com.nrslib.cleanimpl.service.app.infrastructure.jpa.sample.SampleDataModelJpaRepository;
import com.nrslib.cleanimpl.service.app.web.typical.presenters.TypicalCreatePresenter;
import com.nrslib.cleanimpl.service.config.interceptors.ResultFromPresenterInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class ApplicationConfiguration {
    @Bean
    public TypicalCreateInputBoundary typicalCreateInputBoundary(SampleRepository sampleRepository, TypicalCreateOutputBoundary typicalCreateOutputBoundary) {
        return new TypicalCreateInteractor(sampleRepository, typicalCreateOutputBoundary);
    }

    @Bean
    TypicalCreateOutputBoundary typicalCreateOutputBoundary(TypicalCreatePresenter typicalCreatePresenter) {
        return typicalCreatePresenter;
    }

    @Bean
    SampleRepository sampleRepository(SampleDataModelJpaRepository jpaSampleRepository) {
        return new JpaSampleRepository(jpaSampleRepository);
    }

    @Bean
    ResultFromPresenterInterceptor resultFromPresenterInterceptor(ObjectMapper mapper, TypicalCreatePresenter presenter) {
        return new ResultFromPresenterInterceptor(mapper, presenter);
    }

    @Bean
    TypicalCreatePresenter typicalCreatePresenter() {
        return new TypicalCreatePresenter();
    }

    @Bean
    PracticalCreateInputBoundary practicalCreateInputBoundary(SampleRepository sampleRepository) {
        return new PracticalCreateInteractor(sampleRepository);
    }
}
