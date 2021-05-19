package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.School
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SchoolRepository : JpaRepository<School, Int>