package br.com.senac.sideschoolappservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan
@EnableJpaRepositories("br.com.senac.sideschoolappservice.repository")
class SideschoolAppServiceApplication

fun main(args: Array<String>) {
	runApplication<SideschoolAppServiceApplication>(*args)
}
