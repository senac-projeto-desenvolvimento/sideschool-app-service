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
    var question: QuestionEntity? = null

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id_pergunta")
    @JoinTable(
        name = "aluno_resposta",
        joinColumns = [JoinColumn(name = "resposta_id_resposta")],
        inverseJoinColumns = [JoinColumn(name = "aluno_id_aluno")]
    )
    var student: Student? = null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resposta")
    var answerId: Int = 0

    constructor(answer: String, rightAnswer: Int, question: QuestionEntity) : this(answer, rightAnswer) {
        this.question = question
    }
}