package com.nrslib.cleanimpl.service.http.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.MessageFormat;

@Controller
public class RootController {
    private final String swaggerUiPath;

    public RootController(@Value("${springdoc.swagger-ui.path:/swagger-ui.html}") String swaggerUiPath) {
        this.swaggerUiPath = swaggerUiPath;
    }

    @RequestMapping("/")
    public String get() {
        return MessageFormat.format("redirect:{0}", swaggerUiPath);
    }
}
