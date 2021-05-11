package br.com.senac.sideschoolappservice.data

import br.com.senac.sideschoolappservice.data.entity.SubjectEntity

data class HomeworkDto(val id: Int, var description: String, var subject: SubjectEntity?)