package br.com.senac.sideschoolappservice.service

import br.com.senac.sideschoolappservice.data.SchoolDto
import br.com.senac.sideschoolappservice.data.entity.School
import br.com.senac.sideschoolappservice.repository.SchoolRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SchoolService(@Autowired val schoolRepository: SchoolRepository) {

    fun convertDto(school: SchoolDto): School = School(school.name)

    fun save(school: SchoolDto): School = schoolRepository.save(convertDto(school))
    fun findAll(): MutableList<School> = schoolRepository.findAll()
    fun findById(schoolId: Int): School {
        return schoolRepository.findById(schoolId).orElseThrow { HomeworkException.SchoolCreationException("School doesn't exist") }
    }
}