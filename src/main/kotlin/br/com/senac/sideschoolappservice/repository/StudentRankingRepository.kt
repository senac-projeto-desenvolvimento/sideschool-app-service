package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.StudentRanking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface StudentRankingRepository : JpaRepository<StudentRanking, Int> {

    @Query(value = "CALL pontuacao_geral_posicao", nativeQuery = true)
    fun getStudentRanking(): List<StudentRanking>
}