package com.tbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProbeController {
    @GetMapping("/__probe")
    public String probe() {
        return "ok";
    }
}
