package br.com.senac.sideschoolappservice.service

import br.com.senac.sideschoolappservice.data.entity.ClassEntity
import br.com.senac.sideschoolappservice.data.entity.Student
import br.com.senac.sideschoolappservice.data.entity.StudentPoints
import br.com.senac.sideschoolappservice.data.entity.StudentRanking
import br.com.senac.sideschoolappservice.data.enum.Situation
import br.com.senac.sideschoolappservice.repository.StudentPointsRepository
import br.com.senac.sideschoolappservice.repository.StudentRankingRepository
import br.com.senac.sideschoolappservice.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(
    val studentRepository: StudentRepository,
    val classService: ClassService,
    val studentPointsRepository: StudentPointsRepository,
    val studentRankingRepository: StudentRankingRepository) {

    fun findAllByClass(classEntity: ClassEntity): MutableList<Student> = studentRepository.findByClasses(classEntity)
    fun findById(id: Int): Student = studentRepository.findById(id).get()
    fun findAll(): MutableList<Student> = studentRepository.findAll()
    fun save(student: Student): Student = studentRepository.save(student)

    fun findStudentStatus(studentId: Int): StudentPoints? = studentPointsRepository.getStudentPoints(studentId)

    fun getStudentRanking(): List<StudentRanking?> = studentRankingRepository.getStudentRanking()

    fun enroll(studentId: Int, classes: List<Int>): Student {
        val student = findById(studentId)
        student.classes = classes.map { id -> classService.findById(id)}
        student.situation = Situation.ACTIVE.studentSituation

        return studentRepository.save(student)
    }
}