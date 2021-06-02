package br.com.senac.sideschoolappservice.controller

import br.com.senac.sideschoolappservice.data.SubjectData
import br.com.senac.sideschoolappservice.data.dto.SubjectDto
import br.com.senac.sideschoolappservice.service.SubjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("api/sideschool/subject")
class SubjectController(val service: SubjectService) {

    @PostMapping
    fun saveSubject(@RequestBody body: SubjectDto): SubjectDto {
        return service.save(body)
    }

    @GetMapping
    fun getAllSubjects(): List<SubjectData> {
        return service.findAll().map { SubjectData.of(it) }
    }
}