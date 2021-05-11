package br.com.senac.sideschoolappservice.data.converter

import br.com.senac.sideschoolappservice.data.AlternativeDto
import br.com.senac.sideschoolappservice.data.HomeworkDto
import br.com.senac.sideschoolappservice.data.QuestionDto
import br.com.senac.sideschoolappservice.data.entity.AlternativeEntity
import br.com.senac.sideschoolappservice.data.entity.HomeworkEntity
import br.com.senac.sideschoolappservice.data.entity.QuestionEntity
import br.com.senac.sideschoolappservice.data.entity.SubjectEntity
import br.com.senac.sideschoolappservice.repository.SubjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class HomeworkConverter(@Autowired private val subjectRepository: SubjectRepository) {

//    fun convertEntityToDto(homework: HomeworkEntity): HomeworkDto {
//        return HomeworkDto(homework.homeworkId, homework.description, homework.questions.map { questionEntity ->
//            QuestionDto(questionEntity.questionId, questionEntity.description, questionEntity.alternatives.map { alternativeEntity ->
//                AlternativeDto(alternativeEntity.answerId, alternativeEntity.answer, alternativeEntity.rightAnswer)
//            })
//        }, homework.subject.subjectId)
//    }
//
//    fun convertDtoToEntity(homework: HomeworkDto): HomeworkEntity {
//        val subject: SubjectEntity = subjectRepository.findById(homework.subjectId).get()
//
//        return HomeworkEntity(homework.questions.map { question ->
//            QuestionEntity(question.description, question.alternatives.map { alternative ->
//                AlternativeEntity(alternative.answer, alternative.rightAnswer)
//            })
//        }, homework.title, subject)
//    }
}