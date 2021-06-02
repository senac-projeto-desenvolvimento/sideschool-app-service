package br.com.senac.sideschoolappservice.data.entity

import javax.persistence.*

@Entity(name = "disciplina")
open class SubjectEntity(@Column(name = "disciplina") open val title: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    open var subjectId: Int = 0

    @ManyToMany(mappedBy = "subjectClasses")
    open var classes: List<ClassEntity>? = null

}
