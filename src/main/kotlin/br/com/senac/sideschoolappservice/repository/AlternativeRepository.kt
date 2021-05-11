package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.AlternativeEntity
import br.com.senac.sideschoolappservice.data.entity.QuestionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlternativeRepository : JpaRepository<AlternativeEntity, Int> {

    fun findByQuestion(question: QuestionEntity): List<AlternativeEntity>
}