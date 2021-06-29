package br.com.senac.sideschoolappservice.controller

import br.com.senac.sideschoolappservice.data.entity.Student
import br.com.senac.sideschoolappservice.data.response.StudentData
import br.com.senac.sideschoolappservice.data.response.StudentRankingData
import br.com.senac.sideschoolappservice.data.response.StudentStatusPoint
import br.com.senac.sideschoolappservice.service.ClassService
import br.com.senac.sideschoolappservice.service.StudentService
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("/api/sideschool")
class StudentController(val studentService: StudentService, val classService: ClassService) {

    @GetMapping("/class/{classId}/student")
    fun findStudentsByClass(@PathVariable classId: Int): List<StudentData> {
        val classFound = classService.findById(classId)
        return studentService.findAllByClass(classFound).map { StudentData.of(it) }
    }

    @GetMapping("/student")
    fun findStudents(): List<StudentData> {
        return studentService.findAll().map { StudentData.of(it) }
    }

    @PostMapping("/student")
    fun saveStudent(@RequestBody body: Student): StudentData {
        return StudentData.of(studentService.save(body))
    }

    @GetMapping("/student/status")
    fun findStatusPoint(@RequestHeader studentId: Int): StudentStatusPoint {
        return StudentStatusPoint.of(studentService.findStudentStatus(studentId))
    }

    @GetMapping("/student/ranking")
    fun getStudentRanking(): List<StudentRankingData?> {
        return studentService.getStudentRanking().map { StudentRankingData.of(it) }
    }
}