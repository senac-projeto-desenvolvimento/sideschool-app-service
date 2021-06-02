package br.com.senac.sideschoolappservice.data

import br.com.senac.sideschoolappservice.data.entity.AlternativeEntity
import br.com.senac.sideschoolappservice.data.entity.HomeworkEntity
import br.com.senac.sideschoolappservice.data.entity.QuestionEntity
import br.com.senac.sideschoolappservice.data.entity.SubjectEntity
import java.time.LocalDateTime



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