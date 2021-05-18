package br.com.senac.sideschoolappservice.controller

import br.com.senac.sideschoolappservice.data.SchoolData
import br.com.senac.sideschoolappservice.data.SchoolDto
import br.com.senac.sideschoolappservice.data.entity.School
import br.com.senac.sideschoolappservice.service.SchoolService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.*

@RestController
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("api/sideschool")
class SchoolController(@Autowired val schoolService: SchoolService) {

    @PostMapping("/school")
    fun createSchool(@RequestBody schoolBody: SchoolDto): SchoolData {
        return SchoolData.of(schoolService.save(schoolBody))
    }

    @GetMapping("/school")
    fun findAllSchools(): List<SchoolData> {
        return schoolService.findAll().map { SchoolData.of(it) }
    }

    @GetMapping("/school/{schoolId}")
    fun findSchoolById(@PathVariable schoolId: Int): SchoolData {
        return SchoolData.of(schoolService.findById(schoolId))
    }
}