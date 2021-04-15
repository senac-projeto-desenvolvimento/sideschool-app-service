package br.com.senac.sideschoolappservice

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SideschoolAppServiceApplication

fun main(args: Array<String>) {
	runApplication<SideschoolAppServiceApplication>(*args)
}
