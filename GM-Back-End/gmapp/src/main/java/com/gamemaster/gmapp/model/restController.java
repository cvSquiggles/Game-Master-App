package com.gamemaster.gmapp.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

    @GetMapping("/api/mic")
    public String mic() {
        return "check, 1, 2";
    }

}
