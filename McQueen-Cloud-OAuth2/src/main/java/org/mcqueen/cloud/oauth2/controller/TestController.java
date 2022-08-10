package org.mcqueen.cloud.oauth2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class TestController {

    @PostMapping("/login")
    public String login() {
        return "login success";
    }
}
