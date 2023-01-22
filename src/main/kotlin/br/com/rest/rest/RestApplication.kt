package br.com.rest.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["br.com.rest.rest.repositories"])
@EntityScan(basePackages = ["br.com.rest.rest.model"])
@EnableTransactionManagement
class RestApplication

fun main(args: Array<String>) {
	runApplication<RestApplication>(*args)
}
