package com.nrslib.cleanimpl.service.http.controllers;

import com.nrslib.cleanimpl.service.app.application.usecases.practical.inputboundary.PracticalCreateInputBoundary;
import com.nrslib.cleanimpl.service.app.application.usecases.practical.inputboundary.PracticalCreateInputData;
import com.nrslib.cleanimpl.service.http.models.practical.post.PracticalPostRequestModel;
import com.nrslib.cleanimpl.service.http.models.practical.post.PracticalPostResponseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/practical")
public class PracticalController {
    private final PracticalCreateInputBoundary createInputBoundary;

    public PracticalController(PracticalCreateInputBoundary createInputBoundary) {
        this.createInputBoundary = createInputBoundary;
    }

    @PostMapping
    public PracticalPostResponseModel post(@RequestBody PracticalPostRequestModel request) {
        var inputData = new PracticalCreateInputData(request.data());
        var outputData = createInputBoundary.handle(inputData);

        return new PracticalPostResponseModel(outputData.id(), outputData.data());
    }
}
