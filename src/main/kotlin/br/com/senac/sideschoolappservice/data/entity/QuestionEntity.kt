package br.com.senac.sideschoolappservice.data.entity

import javax.persistence.*

@Entity(name = "pergunta")
data class QuestionEntity(@Column(name = "enunciado") var description: String) {

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_atividade", referencedColumnName = "id_atividade")
    private var homework: HomeworkEntity? = null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pergunta")
    var questionId: Int = 0

    constructor(description: String, homework: HomeworkEntity) : this(description) {
        this.homework = homework
    }
}