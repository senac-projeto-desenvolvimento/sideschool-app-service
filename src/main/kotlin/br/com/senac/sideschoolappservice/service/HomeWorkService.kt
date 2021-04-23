package br.com.senac.sideschoolappservice.service

import br.com.senac.sideschoolappservice.data.HomeWorkDto
import br.com.senac.sideschoolappservice.data.QuestionDto
import org.springframework.stereotype.Service

@Service
class HomeWorkService {

    fun getHomework(): HomeWorkDto {
        val alternatives = listOf("A", "B", "C", "D")
        val questionA = QuestionDto(1, "Primeira questão", alternatives, "A")
        val questionB = QuestionDto(2, "Segunda questão", alternatives, "A")
        return HomeWorkDto(1, "Tarefas do dia atual", listOf(questionA, questionB))
    }
}