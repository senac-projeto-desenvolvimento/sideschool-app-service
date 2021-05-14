package br.com.senac.sideschoolappservice.controller

import br.com.senac.sideschoolappservice.data.entity.Class
import br.com.senac.sideschoolappservice.service.ClassService
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("/api/sideschool")
class ClassController(val classService: ClassService) {

    @RequestMapping("class")
    fun getClasses(): MutableList<Class> {
        return classService.findClasses()
    }

}