package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.Class
import org.springframework.data.jpa.repository.JpaRepository

interface ClassRepository : JpaRepository<Class, Int>