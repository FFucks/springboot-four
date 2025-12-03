package com.ffucks.controller;

import com.ffucks.clients.ChristmasJoyClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello", version = "4")
@RequiredArgsConstructor
public class HelloWorldV4Controller {

    private final ChristmasJoyClient christmasJoy;

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello() {
        return this.christmasJoy.getRandomGreeting();
    }

}
