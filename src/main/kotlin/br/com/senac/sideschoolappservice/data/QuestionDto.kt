package br.com.senac.sideschoolappservice.data

data class QuestionDto(val id: Int, val title: String, val alternatives: List<String>, val rightAnswer: String)