package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.School
import org.springframework.data.jpa.repository.JpaRepository

interface SchoolRepository : JpaRepository<School, Int>