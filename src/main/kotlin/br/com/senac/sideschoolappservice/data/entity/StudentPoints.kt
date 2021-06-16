package br.com.senac.sideschoolappservice.data.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "vw_pontuacao_geral")
class StudentPoints(
    @Id @Column(name = "id_aluno") var studentId: Int,
    @Column(name = "nome") var name: String,
    @Column(name = "pontuacao") var points: Int,
    @Column(name = "moeda") var coins: Int,
    @Column(name = "moeda_gasta") var coinCount: Int,
    @Column(name = "saldo") var balance: Int)