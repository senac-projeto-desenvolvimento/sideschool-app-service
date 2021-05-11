package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.HomeworkEntity
import br.com.senac.sideschoolappservice.data.entity.SubjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HomeworkRepository : JpaRepository<HomeworkEntity, Int> {

    fun findFirstByDescription(descripion: String): HomeworkEntity

    fun findBySubject(subject: SubjectEntity): List<HomeworkEntity>

    override fun findAll(): List<HomeworkEntity>

}