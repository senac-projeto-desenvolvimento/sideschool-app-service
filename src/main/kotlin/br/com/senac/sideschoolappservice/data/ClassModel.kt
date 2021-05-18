package br.com.senac.sideschoolappservice.data

import br.com.senac.sideschoolappservice.data.entity.Class
import br.com.senac.sideschoolappservice.data.entity.School

data class ClassDto(var name: String, var school: School?)

data class ClassData(val id: Int, val name: String){
    companion object {
        fun of(source: Class) = ClassData(source.classId, source.name)
    }
}
