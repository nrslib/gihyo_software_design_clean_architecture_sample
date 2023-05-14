package com.nrslib.cleanimpl.service.app.web.typical.presenters;

import com.nrslib.cleanimpl.service.app.application.usecases.typical.outputboundary.TypicalCreateOutputBoundary;
import com.nrslib.cleanimpl.service.app.application.usecases.typical.outputboundary.TypicalCreateOutputData;
import com.nrslib.cleanimpl.service.http.models.typical.post.TypicalPostResponseModel;

public class TypicalCreatePresenter implements TypicalCreateOutputBoundary {
    private TypicalPostResponseModel viewModel;

    @Override
    public void handle(TypicalCreateOutputData outputData) {
        viewModel = new TypicalPostResponseModel(outputData.id(), outputData.data());
    }

    public TypicalPostResponseModel result() {
        return viewModel;
    }
}
