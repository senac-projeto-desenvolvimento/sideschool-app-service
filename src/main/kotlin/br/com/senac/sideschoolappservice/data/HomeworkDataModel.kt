package br.com.senac.sideschoolappservice.data

import br.com.senac.sideschoolappservice.data.entity.HomeworkEntity
import br.com.senac.sideschoolappservice.data.entity.QuestionEntity
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
                            , val questions: List<QuestionEntity>) {

    companion object {
        fun of(homework: HomeworkEntity, questions: List<QuestionEntity>) = HomeworkResponse(homework.homeworkId, homework.description, questions)
    }
}
