package br.com.senac.sideschoolappservice.data.entity

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "turma")
class ClassEntity(@Column(name = "nome_turma") var name: String) {

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_escola", referencedColumnName = "id_escola")
    private var school: School? = null

//    @ManyToMany(mappedBy = "classes")
//    var subjects: MutableList<SubjectEntity> = ArrayList()

    @ManyToMany
    @JoinTable(
        name = "turma_disciplina",
        joinColumns = [JoinColumn(name = "turma_id_turma")],
        inverseJoinColumns = [JoinColumn(name = "disciplina_id_disciplina")]
    )
    var subjects: MutableList<SubjectEntity> = ArrayList()

    @ManyToMany(mappedBy = "classes")
    var students: List<Student>? = null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    var classId: Int = 0

    @Column(name = "data_turma")
    @CreatedDate
    private var createdDate: LocalDateTime? = LocalDateTime.now()

    constructor(name: String, school: School, subjects: MutableList<SubjectEntity>) : this(name) {
        this.school = school
        this.subjects = subjects
    }

    constructor(name: String, school: School) : this(name) {
        this.school = school
    }
}