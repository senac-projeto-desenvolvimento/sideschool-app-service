package br.com.senac.sideschoolappservice.service

import br.com.senac.sideschoolappservice.data.dto.SubjectDto
import br.com.senac.sideschoolappservice.data.converter.SubjectConverter
import br.com.senac.sideschoolappservice.data.entity.ClassEntity
import br.com.senac.sideschoolappservice.data.entity.SubjectEntity
import br.com.senac.sideschoolappservice.repository.SubjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SubjectService(val repository: SubjectRepository, val converter: SubjectConverter) {

    fun save(subject: SubjectDto): SubjectDto {
        return converter.convertSubjectEntityToDto(repository.save(converter.convertSubjectDtoToEntity(subject)))
    }

    fun findById(id: Int): SubjectEntity {
        return repository.findById(id).get()
    }

    fun findAllByClass(classEntity: List<ClassEntity>): List<SubjectEntity> {
        val subjects = findAll()
        val classId = classEntity.map { it.classId }[0]
        return subjects.flatMap { sub -> sub.classes.filter { it.classId == classId } }[0].subjects
    }

    fun findAll(): List<SubjectEntity> {
        return repository.findAll()
    }
}