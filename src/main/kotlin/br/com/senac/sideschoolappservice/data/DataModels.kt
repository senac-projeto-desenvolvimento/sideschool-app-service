package br.com.senac.sideschoolappservice.data

import br.com.senac.sideschoolappservice.data.entity.AlternativeEntity
import br.com.senac.sideschoolappservice.data.entity.HomeworkEntity
import br.com.senac.sideschoolappservice.data.entity.QuestionEntity
import br.com.senac.sideschoolappservice.data.entity.SubjectEntity
import java.time.LocalDateTime

data class HomeworkData(val homeworkId: Int?
                      , val description: String
                      , val createdDate: LocalDateTime) {

    companion object {
        fun of(source: HomeworkEntity) = HomeworkData(source.homeworkId, source.description, source.createdDate)
    }
}

data class HomeworkResponse(val homeworkId: Int?
                            , val description: String
                            , val questions: QuestionEntity
                            , val alternatives: List<AlternativeEntity>) {

    companion object {
        fun of(homework: HomeworkEntity, question: QuestionEntity, alternatives: List<AlternativeEntity>) = HomeworkResponse(homework.homeworkId, homework.description, question, alternatives)
    }
}

class SubjectData(val subjectId: Int?
                , val title: String) {

    companion object {
        fun of(source: SubjectEntity) = SubjectData(source.subjectId, source.title)
    }
}

class QuestionData(val questionId: Int?
                   , val description: String) {

    companion object {
        fun of(source: QuestionEntity) = QuestionData(source.questionId, source.description)
    }
}

class AlternativeData(val alternativeId: Int?
                   , val answer: String
                   , val rightAnswer: Int) {

    companion object {
        fun of(source: AlternativeEntity) = AlternativeData(source.answerId, source.answer, source.rightAnswer)
    }
}