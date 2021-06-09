package br.com.senac.sideschoolappservice.data.response

import br.com.senac.sideschoolappservice.data.entity.Student

data class StudentDto(val id: Int, val name: String, val birthDate: String)

data class StudentData(val id: Int, val name: String, val birthDate: String, val situation: Int) {
    companion object {
        fun of(source: Student) = StudentData(source.studentId, source.name, source.birthdate.toString(), source.situation)
    }
}