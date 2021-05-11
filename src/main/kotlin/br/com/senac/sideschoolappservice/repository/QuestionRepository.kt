package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.HomeworkEntity
import br.com.senac.sideschoolappservice.data.entity.QuestionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : JpaRepository<QuestionEntity, Int> {

    fun findByHomework(homework: HomeworkEntity): List<QuestionEntity>

}