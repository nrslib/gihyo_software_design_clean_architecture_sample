package com.nrslib.cleanimpl.service.config.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nrslib.cleanimpl.service.app.web.typical.presenters.TypicalCreatePresenter;
import com.nrslib.cleanimpl.service.http.controllers.TypicalController;
import com.nrslib.cleanimpl.service.http.models.typical.post.TypicalPostResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ResultFromPresenterInterceptor implements HandlerInterceptor {
    private final ObjectMapper mapper;
    private final TypicalCreatePresenter createPresenter;

    public ResultFromPresenterInterceptor(ObjectMapper mapper, TypicalCreatePresenter createPresenter) {
        this.mapper = mapper;
        this.createPresenter = createPresenter;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (handler instanceof HandlerMethod handlerMethod) {
            if (handlerMethod.getBeanType() == TypicalController.class) {
                if (handlerMethod.getMethod().getName().equals("post")) {
                    var result = createPresenter.result();
                    var responseModel = new TypicalPostResponseModel(result.id(), result.data());
                    var contents = mapper.writeValueAsString(responseModel);
                    response.getWriter().println(contents);
                }
            }
        }
    }
}
