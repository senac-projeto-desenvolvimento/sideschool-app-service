package br.com.senac.sideschoolappservice.data

import br.com.senac.sideschoolappservice.data.entity.ClassEntity
import br.com.senac.sideschoolappservice.data.entity.School

data class ClassDto(var name: String, var school: School?)

data class ClassData(val id: Int, val name: String, val students: List<StudentData>?){
    companion object {
        fun of(source: ClassEntity): ClassData {
            return ClassData(source.classId, source.name, source.students?.map {
                StudentData(it.studentId, it.name, it.document, it.situation)
            })
        }
    }
}
