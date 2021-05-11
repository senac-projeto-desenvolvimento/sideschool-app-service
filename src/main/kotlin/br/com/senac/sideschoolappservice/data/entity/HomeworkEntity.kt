package br.com.senac.sideschoolappservice.data.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "atividade")
open class HomeworkEntity(@Column(name = "enunciado") open var description: String) {

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")
    private var subject: SubjectEntity? = null

//    @OneToMany(mappedBy = "homework", cascade = [CascadeType.ALL], orphanRemoval = true)
//    open var questions : MutableList<QuestionEntity> = ArrayList()

    @Column(name = "data_atividade")
    open var createdDate: LocalDateTime = LocalDateTime.now()

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atividade")
    open var homeworkId: Int = 0

    constructor(description: String, subject: SubjectEntity) : this(description) {
        this.subject = subject
    }
}