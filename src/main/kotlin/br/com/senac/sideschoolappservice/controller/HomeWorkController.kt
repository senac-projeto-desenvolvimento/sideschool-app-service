package br.com.senac.sideschoolappservice.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sideschool/api/homework")
class HomeWorkController {

    @GetMapping()
    fun getHomeWork(): String {
        return "homework oh yeah"
    }
}