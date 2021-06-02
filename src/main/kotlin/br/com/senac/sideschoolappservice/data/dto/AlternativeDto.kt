package br.com.senac.sideschoolappservice.data

import br.com.senac.sideschoolappservice.data.entity.QuestionEntity

data class AlternativeDto(val answerId: Int, val answer: String, val rightAnswer: Int, var question: QuestionEntity?)