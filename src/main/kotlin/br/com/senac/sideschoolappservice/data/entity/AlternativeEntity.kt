package br.com.senac.sideschoolappservice.data.entity

import javax.persistence.*

@Entity(name = "resposta")
data class AlternativeEntity(
    @Column(name = "resposta")
    var answer: String,

    @Column(name = "correta")
    var rightAnswer: Int) {

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pergunta", referencedColumnName = "id_pergunta")
    private var question: QuestionEntity? = null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resposta")
    var answerId: Int = 0

    constructor(answer: String, rightAnswer: Int, question: QuestionEntity) : this(answer, rightAnswer) {
        this.question = question
    }
}