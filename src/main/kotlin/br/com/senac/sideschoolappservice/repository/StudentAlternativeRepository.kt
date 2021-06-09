package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.AlternativeEntity
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Repository
class StudentAlternativeRepository {

    @PersistenceContext
    lateinit var entityManager: EntityManager

    @Transactional
    fun submitHomework(alternativeEntity: AlternativeEntity) {
        entityManager.createNativeQuery("insert INTO aluno_resposta (aluno_id_aluno, resposta_id_resposta, data_resposta, id_pergunta) " +
                "values (:studentId, :alternativeId, :answerDate, :questionId)")
            .setParameter("studentId", alternativeEntity.student?.studentId)
            .setParameter("alternativeId", alternativeEntity.answerId)
            .setParameter("answerDate", LocalDateTime.now())
            .setParameter("questionId", alternativeEntity.question?.questionId)
            .executeUpdate()
    }
}