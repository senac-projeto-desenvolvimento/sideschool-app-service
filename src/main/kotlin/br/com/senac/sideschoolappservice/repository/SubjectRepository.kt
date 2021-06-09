package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.ClassEntity
import br.com.senac.sideschoolappservice.data.entity.SubjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface SubjectRepository : JpaRepository<SubjectEntity, Int> {

    @Query(value = "select sub from disciplina sub where sub.classes in :ids")
    fun findByClasses(@Param("ids") classId: List<ClassEntity>): List<SubjectEntity>
}