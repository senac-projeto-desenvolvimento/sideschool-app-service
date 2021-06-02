package br.com.senac.sideschoolappservice.data.converter

import br.com.senac.sideschoolappservice.data.dto.SubjectDto
import br.com.senac.sideschoolappservice.data.entity.SubjectEntity
import org.springframework.stereotype.Component

@Component
class SubjectConverter {

    fun convertSubjectEntityToDto(subject: SubjectEntity): SubjectDto {
        return SubjectDto(subject.subjectId, subject.title)
    }

    fun convertSubjectDtoToEntity(subject: SubjectDto): SubjectEntity {
        return SubjectEntity(subject.title)
    }
}