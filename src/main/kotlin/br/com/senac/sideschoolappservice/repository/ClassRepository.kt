package br.com.senac.sideschoolappservice.repository

import br.com.senac.sideschoolappservice.data.entity.ClassEntity
import br.com.senac.sideschoolappservice.data.entity.School
import br.com.senac.sideschoolappservice.data.entity.Student
import br.com.senac.sideschoolappservice.data.entity.SubjectEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClassRepository : JpaRepository<ClassEntity, Int> {

    fun findBySchool(school: School): MutableList<ClassEntity>

    fun findBySchoolAndClassId(school: School, classId: Int): ClassEntity

    fun findAllByStudents(student: Student): MutableList<ClassEntity>

    fun findBySubjectClasses(subject: SubjectEntity): MutableList<ClassEntity>
}