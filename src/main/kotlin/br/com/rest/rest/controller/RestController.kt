package br.com.rest.rest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class RestController {
    @GetMapping
    fun hello():String {
        return "dae asdasdasd"
    }
}