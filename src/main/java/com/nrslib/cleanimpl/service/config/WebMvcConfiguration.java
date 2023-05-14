package com.nrslib.cleanimpl.service.config;

import com.nrslib.cleanimpl.service.config.interceptors.ResultFromPresenterInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final ResultFromPresenterInterceptor getPresenterInterceptor;

    public WebMvcConfiguration(ResultFromPresenterInterceptor getPresenterInterceptor) {this.getPresenterInterceptor = getPresenterInterceptor;}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getPresenterInterceptor);
    }
}
