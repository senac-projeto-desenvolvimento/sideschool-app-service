package br.com.senac.sideschoolappservice.data.response

import br.com.senac.sideschoolappservice.data.entity.StudentAlternativeEntity
import br.com.senac.sideschoolappservice.data.entity.StudentPoints
import java.time.LocalDateTime

data class StudentStatusPoint(
    val studentName: String,
    val points: Int,
    val coins: Int,
    val coinCount: Int,
    val balance: Int) {
    companion object {
        fun of(source: StudentPoints) = StudentStatusPoint(source.name, source.points, source.coins, source.coinCount, source.balance)
    }
}

data class StudentHomeworkResult(
    val rightAnswers: Int,
    val wrongAnswers: Int)
