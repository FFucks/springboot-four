package com.ffucks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;

@Configuration
@Import(HttpClientConfig.HelloWorldClientHttpServiceRegistrar.class)
public class HttpClientConfig {

    static class HelloWorldClientHttpServiceRegistrar extends AbstractClientHttpServiceRegistrar {

        @Override
        protected void registerHttpServices(GroupRegistry registry, AnnotationMetadata metadata) {
            findAndRegisterHttpServiceClients(registry, List.of("com.baeldung.spring.mvc"));
        }
    }

    @Bean
    RestClientHttpServiceGroupConfigurer christmasJoyServiceGroupConfigurer() String baseUrl) {
        return groups -> {
            groups.filterByName("christmasJoy")
                    .forEachClient((group, clientBuilder) -> {
                        clientBuilder.baseUrl("https://christmasjoy.dev/api");
                    });
        };
    }

}
