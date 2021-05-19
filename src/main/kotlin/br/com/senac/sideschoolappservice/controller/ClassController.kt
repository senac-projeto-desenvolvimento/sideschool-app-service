package br.com.senac.sideschoolappservice.controller

import br.com.senac.sideschoolappservice.data.*
import br.com.senac.sideschoolappservice.data.entity.School
import br.com.senac.sideschoolappservice.service.ClassService
import br.com.senac.sideschoolappservice.service.SchoolService
import br.com.senac.sideschoolappservice.service.StudentService
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("/api/sideschool")
class ClassController(val classService: ClassService, val schoolService: SchoolService, val studentService: StudentService) {

    @PostMapping("school/{schoolId}/class")
    fun saveClass(@PathVariable schoolId: Int, @RequestBody body: ClassDto): ClassData {
        body.school = schoolService.findById(schoolId)
        return ClassData.of(classService.save(body))
    }

    @GetMapping("school/{schoolId}/class")
    fun findClassesBySchool(@PathVariable schoolId: Int): ResponseEntity<List<ClassData>> {
        val school: School
        try {
            school = schoolService.findById(schoolId)
        } catch (exception: RuntimeException) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(classService.findAllBySchool(school).map { ClassData.of(it) })
    }

    @GetMapping("school/{schoolId}/class/{classId}")
    fun findClassesBySchool(@PathVariable schoolId: Int, @PathVariable classId: Int): ResponseEntity<ClassData> {
        val school: School
        try {
            school = schoolService.findById(schoolId)
        } catch (exception: RuntimeException) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(ClassData.of(classService.findBySchoolAndId(school, classId)))
    }

}