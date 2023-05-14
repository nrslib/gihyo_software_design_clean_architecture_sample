package com.nrslib.cleanimpl.service.http.controllers;

import com.nrslib.cleanimpl.service.app.application.usecases.typical.inputboundary.TypicalCreateInputBoundary;
import com.nrslib.cleanimpl.service.app.application.usecases.typical.inputboundary.TypicalCreateInputData;
import com.nrslib.cleanimpl.service.http.models.typical.post.TypicalPostRequestModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/typical")
public class TypicalController {
    private final TypicalCreateInputBoundary createInputBoundary;

    public TypicalController(TypicalCreateInputBoundary createInputBoundary) {
        this.createInputBoundary = createInputBoundary;
    }

    @PostMapping
    public void post(@RequestBody TypicalPostRequestModel request) {
        var inputData = new TypicalCreateInputData(request.data());
        createInputBoundary.handle(inputData);
    }
}
