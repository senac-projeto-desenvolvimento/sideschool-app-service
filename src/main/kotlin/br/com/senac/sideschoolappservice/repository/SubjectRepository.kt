package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.SubjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface SubjectRepository : JpaRepository<SubjectEntity, Int>