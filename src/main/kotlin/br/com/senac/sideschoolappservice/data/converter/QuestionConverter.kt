package br.com.senac.sideschoolappservice.data.converter

import br.com.senac.sideschoolappservice.data.QuestionDto
import br.com.senac.sideschoolappservice.data.entity.QuestionEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class QuestionConverter(@Autowired val converter: AlternativeConverter) {

//    fun convertQuestionEntityToDto(question: QuestionEntity): QuestionDto {
//        return QuestionDto(question.questionId, question.description, converter.convertAlternativeDtoToEntity(question.alternatives))
//    }
//
//    fun convertQuestionEntityToDto(questions: List<QuestionEntity>): List<QuestionDto> {
//        return questions.map { convertQuestionEntityToDto(it) }
//    }
}