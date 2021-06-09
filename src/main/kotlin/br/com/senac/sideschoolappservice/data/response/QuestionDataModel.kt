package br.com.senac.sideschoolappservice.data.response

import br.com.senac.sideschoolappservice.data.entity.AlternativeEntity
import br.com.senac.sideschoolappservice.data.entity.QuestionEntity

class QuestionData(val questionId: Int?
                   , val description: String
                   , val alternativeEntity: List<AlternativeData>) {

    companion object {
        fun of(source: QuestionEntity) = QuestionData(source.questionId, source.description, source.alternatives.map {
            AlternativeData.of(it)
        })
    }
}

class AlternativeData(val alternativeId: Int?
                   , val answer: String
                   , val rightAnswer: Int) {

    companion object {
        fun of(source: AlternativeEntity) = AlternativeData(source.answerId, source.answer, source.rightAnswer)
    }
}
