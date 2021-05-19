package br.com.senac.sideschoolappservice.controller

import br.com.senac.sideschoolappservice.data.entity.Student
import br.com.senac.sideschoolappservice.service.ClassService
import br.com.senac.sideschoolappservice.service.StudentService
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.*

@RestController
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("/api/sideschool")
class StudentController(val studentService: StudentService, val classService: ClassService) {

    @GetMapping("/class/{classId}/student")
    fun findStudentsByClass(@PathVariable classId: Int): List<Student> {
        val classFound = classService.findById(classId)
        return studentService.findAllByClass(classFound)
    }

    @GetMapping("/student")
    fun findStudents(): List<Student> {
        return studentService.findAll()
    }

    @PostMapping("/student")
    fun saveStudent(@RequestBody body: Student): Student {
        return studentService.save(body)
    }
}