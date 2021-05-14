package br.com.senac.sideschoolappservice.service

import br.com.senac.sideschoolappservice.data.entity.Class
import br.com.senac.sideschoolappservice.repository.ClassRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClassService(@Autowired private val classRepository: ClassRepository) {

    fun findClasses(): MutableList<Class> = classRepository.findAll()
}