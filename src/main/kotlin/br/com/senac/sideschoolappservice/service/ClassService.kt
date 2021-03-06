package br.com.senac.sideschoolappservice.service

import br.com.senac.sideschoolappservice.data.response.ClassDto
import br.com.senac.sideschoolappservice.data.entity.ClassEntity
import br.com.senac.sideschoolappservice.data.entity.School
import br.com.senac.sideschoolappservice.data.entity.Student
import br.com.senac.sideschoolappservice.repository.ClassRepository
import br.com.senac.sideschoolappservice.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class ClassService(private val classRepository: ClassRepository, private val subjectService: SubjectService) {

    fun convertDto(classDto: ClassDto): ClassEntity = ClassEntity(classDto.name, classDto.school ?: throw HomeworkException.HomeworkCreationException("Class doesn't exist"))

    fun findClasses(): MutableList<ClassEntity> = classRepository.findAll()

    fun findByStudent(student: Student): MutableList<ClassEntity> = classRepository.findAllByStudents(student)
    fun findAllBySchool(school: School): MutableList<ClassEntity> = classRepository.findBySchool(school)
    fun findBySchoolAndId(school: School, classId: Int): ClassEntity = classRepository.findBySchoolAndClassId(school, classId)

    fun findById(id: Int): ClassEntity = classRepository.findById(id).orElseThrow { HomeworkException.SchoolCreationException("Class doesn't exist")  }

    fun save(classRequest: ClassDto): ClassEntity = classRepository.save(convertDto(classRequest))
    fun save(classRequest: ClassEntity): ClassEntity = classRepository.save(classRequest)

    fun enroll(classId: Int, subjects: List<Int>): ClassEntity {
        val classFound = findById(classId)
        classFound.subjects = subjects.map { id -> subjectService.findById(id) }.toMutableList()

        return classRepository.save(classFound)
    }
}