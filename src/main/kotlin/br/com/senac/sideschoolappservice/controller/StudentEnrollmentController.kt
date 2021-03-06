package br.com.senac.sideschoolappservice.controller

import br.com.senac.sideschoolappservice.data.response.StudentData
import br.com.senac.sideschoolappservice.service.StudentService
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("api/sideschool")
class StudentEnrollmentController(val studentService: StudentService) {

    @PutMapping("/student/{studentId}/enroll")
    fun enrollStudent(@PathVariable studentId: Int, @RequestBody classesList: List<Int>): ResponseEntity<StudentData> {
        val studentEnroll: StudentData
        try {
            studentEnroll = StudentData.of(studentService.enroll(studentId, classesList))
        }catch (e: RuntimeException) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(studentEnroll)
    }

}