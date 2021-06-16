package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.StudentAlternativeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlternativeStudentResultRepository : JpaRepository<StudentAlternativeEntity, Int> {

    fun findByQuestionId(questionId: Int): List<StudentAlternativeEntity>

    fun findByQuestionIdAndStudentId(questionId: Int, studentId: Int): List<StudentAlternativeEntity>
}