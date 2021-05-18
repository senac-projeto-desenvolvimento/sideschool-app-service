package br.com.senac.sideschoolappservice.service

import br.com.senac.sideschoolappservice.data.ClassDto
import br.com.senac.sideschoolappservice.data.entity.Class
import br.com.senac.sideschoolappservice.data.entity.School
import br.com.senac.sideschoolappservice.repository.ClassRepository
import org.springframework.stereotype.Service

@Service
class ClassService(private val classRepository: ClassRepository) {

    fun convertDto(classDto: ClassDto): Class = Class(classDto.name, classDto.school ?: throw HomeworkException.HomeworkCreationException("Class doesn't exist"))

    fun findClasses(): MutableList<Class> = classRepository.findAll()
    fun findBySchool(school: School): MutableList<Class> = classRepository.findBySchool(school)
    fun save(classRequest: ClassDto): Class = classRepository.save(convertDto(classRequest))
}