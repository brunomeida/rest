package br.com.rest.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestApplication

fun main(args: Array<String>) {
	System.setProperty("spring.devtools.restart.enabled", "true");
	runApplication<RestApplication>(*args)
}
