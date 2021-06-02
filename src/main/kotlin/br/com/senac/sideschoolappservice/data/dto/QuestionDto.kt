package br.com.senac.sideschoolappservice.data.dto

import br.com.senac.sideschoolappservice.data.entity.HomeworkEntity

data class QuestionDto(val id: Int, var description: String, var homework: HomeworkEntity?)