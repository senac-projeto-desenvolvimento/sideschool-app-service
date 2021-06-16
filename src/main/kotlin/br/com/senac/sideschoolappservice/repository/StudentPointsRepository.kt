package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.StudentPoints
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface StudentPointsRepository : JpaRepository<StudentPoints, Int> {

    @Query("select u from vw_pontuacao_geral u where id_aluno = :studentId")
    fun getStudentPoints(studentId: Int): StudentPoints
}