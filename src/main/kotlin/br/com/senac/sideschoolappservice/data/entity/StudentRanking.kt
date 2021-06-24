package br.com.senac.sideschoolappservice.data.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "pontuacao_geral_posicao")
class StudentRanking(
    @Id @Column(name = "id_aluno") var studentId: Int,
    @Column(name = "posicao") var position: Int? = 0,
    @Column(name = "nome") var name: String,
    @Column(name = "pontuacao") var points: Int? = 0,
    @Column(name = "moeda") var coins: Int? = 0,
    @Column(name = "moeda_gasta") var coinCount: Int? = 0,
    @Column(name = "saldo") var balance: Int? = 0)