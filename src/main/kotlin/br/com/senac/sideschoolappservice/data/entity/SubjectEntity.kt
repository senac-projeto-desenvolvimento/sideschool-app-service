package br.com.senac.sideschoolappservice.data.entity

import javax.persistence.*

@Entity(name = "disciplina")
open class SubjectEntity(@Column(name = "disciplina") open val title: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    open var subjectId: Int = 0

    @ManyToMany(mappedBy = "subjects")
    open var classes: List<ClassEntity> = ArrayList()

//    @ManyToMany
//    @JoinTable(
//        name = "turma_disciplina",
//        joinColumns = [JoinColumn(name = "disciplina_id_disciplina")],
//        inverseJoinColumns = [JoinColumn(name = "turma_id_turma")]
//    )
//    var classes: MutableList<ClassEntity> = ArrayList()

}
