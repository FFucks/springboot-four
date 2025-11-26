package com.ffucks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiConfig implements WebMvcConfigurer {

    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer.usePathSegment(1);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //path-based mapping (e.g. /api/v1/hello vs. /api/v2/hello)
        //query-parameter-based (e.g. /hello?version=1 vs. /hello?version=2)
        //request-header-based (e.g. X-API-Version: 1 vs. X-API-Version: 2)
        //mediatype-header-based (e.g. Accept: application/json; version=1 vs. Accept: application/json; version=2)
        configurer.addPathPrefix("/api/v{version}", HandlerTypePredicate.forAnnotation(RestController.class));
    }

}
