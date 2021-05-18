package br.com.senac.sideschoolappservice.controller

import br.com.senac.sideschoolappservice.data.SubjectDto
import br.com.senac.sideschoolappservice.service.SubjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.*

@RestController
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("api/sideschool/subject")
class SubjectController(@Autowired val service: SubjectService) {

    @PostMapping
    fun saveSubject(@RequestBody body: SubjectDto): SubjectDto {
        return service.save(body)
    }

    @GetMapping
    fun getAllSubjects(): List<SubjectDto> {
        return service.findAll()
    }

//    @GetMapping
//    fun findAllByClass(): List<SubjectDto> {
//        return service.findAll()
//    }
}