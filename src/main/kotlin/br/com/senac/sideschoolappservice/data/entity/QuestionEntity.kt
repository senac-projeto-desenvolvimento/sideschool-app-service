package br.com.senac.sideschoolappservice.data.entity

import javax.persistence.*

@Entity(name = "pergunta")
data class QuestionEntity(@Column(name = "enunciado") var description: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pergunta")
    var questionId: Int = 0

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_atividade", referencedColumnName = "id_atividade")
    private var homework: HomeworkEntity? = null

    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], orphanRemoval = true)
    var alternatives : List<AlternativeEntity> = ArrayList()

    constructor(description: String, homework: HomeworkEntity) : this(description) {
        this.homework = homework
    }
}