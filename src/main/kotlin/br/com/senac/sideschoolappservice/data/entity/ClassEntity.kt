package br.com.senac.sideschoolappservice.data.entity

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "turma")
class ClassEntity(@Column(name = "nome_turma") var name: String) {

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_escola", referencedColumnName = "id_escola")
    private var school: School? = null

    @ManyToMany
    @JoinTable(
        name = "turma_disciplina",
        joinColumns = [JoinColumn(name = "id_turma")],
        inverseJoinColumns = [JoinColumn(name = "id_disciplina")]
    )
    private var subjectClasses: MutableList<SubjectEntity>? = null

    @ManyToMany(mappedBy = "classes")
    var students: List<Student>? = null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    var classId: Int = 0

    @Column(name = "data_turma")
    @CreatedDate
    private var createdDate: LocalDateTime? = LocalDateTime.now()

    constructor(name: String, school: School) : this(name) {
        this.school = school
    }
}