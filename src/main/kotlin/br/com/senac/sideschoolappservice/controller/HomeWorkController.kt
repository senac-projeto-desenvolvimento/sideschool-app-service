package br.com.senac.sideschoolappservice.controller

import br.com.senac.sideschoolappservice.data.HomeWorkDto
import br.com.senac.sideschoolappservice.service.HomeWorkService
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("/sideschool/api/homework")
class HomeWorkController(val homeWorkService: HomeWorkService) {

    @GetMapping
    fun getHomeWork(): HomeWorkDto {
        return homeWorkService.getHomework()
    }
}