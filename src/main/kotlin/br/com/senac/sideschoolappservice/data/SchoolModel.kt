package br.com.senac.sideschoolappservice.data

import br.com.senac.sideschoolappservice.data.entity.School

data class SchoolDto(var name: String)

data class SchoolData(val id: Int, var name: String){
    companion object {
        fun of(source: School): SchoolData = SchoolData(source.schoolId, source.name)
    }
}