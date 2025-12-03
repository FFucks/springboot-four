package com.ffucks.clients;

import org.springframework.resilience.annotation.ConcurrencyLimit;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.web.service.annotation.GetExchange;

@HttpServiceClient("christmasJoy")
public interface ChristmasJoyClient {

    @GetExchange("/greetings?random")
    @Retryable(maxAttempts = 3, delay = 100, multiplier = 2, maxDelay = 1000)
    @ConcurrencyLimit(3)
    String getRandomGreeting();

}
