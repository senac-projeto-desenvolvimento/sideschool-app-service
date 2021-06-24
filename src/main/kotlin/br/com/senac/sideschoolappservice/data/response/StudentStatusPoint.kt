package br.com.senac.sideschoolappservice.data.response

import br.com.senac.sideschoolappservice.data.entity.StudentPoints
import br.com.senac.sideschoolappservice.data.entity.StudentRanking

data class StudentStatusPoint(
    val studentName: String? = "Not found",
    val points: Int? = 0,
    val coins: Int? = 0,
    val coinCount: Int? = 0,
    val balance: Int? = 0) {
    companion object {
        fun of(source: StudentPoints?) = StudentStatusPoint(source?.name, source?.points, source?.coins, source?.coinCount, source?.balance)
    }
}

data class StudentHomeworkResult(
    val rightAnswers: Int,
    val wrongAnswers: Int)


data class StudentRankingData(
    val rankingPosition: Int? = 0,
    val studentName: String? = "Not found",
    val points: Int? = 0) {
    companion object {
        fun of(source: StudentRanking?) = StudentRankingData(source?.position, source?.name, source?.points)
    }
}
