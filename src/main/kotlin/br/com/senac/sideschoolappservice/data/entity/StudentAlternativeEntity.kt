package br.com.senac.sideschoolappservice.data.entity

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "aluno_resposta")
class StudentAlternativeEntity(
    @Id @Column(name = "id_pergunta") val questionId: Int,
    @Column(name = "aluno_id_aluno") val studentId: Int,
    @Column(name = "resposta_id_resposta") val answerId: Int,
    @Column(name = "data_resposta") val answerDate: LocalDateTime
)