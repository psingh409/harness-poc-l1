package com.jpmorgan.sample.api

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

@RestController
class HelloController {
    @GetMapping("/api/harness/helloWorld")
    
    fun helloWorld() = "Hello World"
}