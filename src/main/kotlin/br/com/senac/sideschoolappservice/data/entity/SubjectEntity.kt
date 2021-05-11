package br.com.senac.sideschoolappservice.data.entity

import javax.persistence.*

@Entity(name = "disciplina")
open class SubjectEntity(@Column(name = "disciplina") open val title: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    open var subjectId: Int = 0

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    open var homeworks : MutableList<HomeworkEntity>  = ArrayList()
}
