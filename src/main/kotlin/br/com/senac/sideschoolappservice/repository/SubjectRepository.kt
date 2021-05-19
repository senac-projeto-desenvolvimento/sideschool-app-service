package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.SubjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SubjectRepository : JpaRepository<SubjectEntity, Int>