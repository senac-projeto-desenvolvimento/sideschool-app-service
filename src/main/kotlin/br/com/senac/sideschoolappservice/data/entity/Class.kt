package br.com.senac.sideschoolappservice.data.entity

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "turma")
class Class(var name: String) {

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_escola", referencedColumnName = "id_escola")
    private var school: School? = null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    var classId: Int = 0

    @Column(name = "data_turma")
    @CreatedDate
    var createdDate: LocalDateTime? = null

    constructor(name: String, school: School) : this(name) {
        this.school = school
    }
}