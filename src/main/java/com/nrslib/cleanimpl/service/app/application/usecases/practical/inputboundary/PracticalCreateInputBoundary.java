package com.nrslib.cleanimpl.service.app.application.usecases.practical.inputboundary;

import com.nrslib.cleanimpl.service.app.application.usecases.practical.outputboundary.PracticalCreateOutputData;

public interface PracticalCreateInputBoundary {
    PracticalCreateOutputData handle(PracticalCreateInputData inputData);
}
