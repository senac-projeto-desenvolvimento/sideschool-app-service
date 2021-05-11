package br.com.senac.sideschoolappservice.service

import br.com.senac.sideschoolappservice.data.SubjectDto
import br.com.senac.sideschoolappservice.data.converter.SubjectConverter
import br.com.senac.sideschoolappservice.repository.SubjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SubjectService(
    @Autowired val repository: SubjectRepository,
    @Autowired val converter: SubjectConverter
    ) {

    fun save(subject: SubjectDto): SubjectDto {
        return converter.convertSubjectEntityToDto(repository.save(converter.convertSubjectDtoToEntity(subject)))
    }

    fun findAll(): List<SubjectDto> {
        return repository.findAll().map { converter.convertSubjectEntityToDto(it) }
    }
}