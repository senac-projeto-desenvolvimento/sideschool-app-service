package br.com.senac.sideschoolappservice.data.entity

import java.time.LocalDate
import javax.persistence.*

@Entity(name = "aluno")
class Student(
    @Column(name = "nome") var name: String,
    @Column(name = "cpf") var document: String,
    @Column(name = "data_nascimento") var birthdate: LocalDate) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    var studentId: Int = 0

    @Column(name = "situacao")
    var situation:  Int = 0

    @ManyToMany
    @JoinTable(
        name = "aluno_turma",
        joinColumns = [JoinColumn(name = "id_aluno")],
        inverseJoinColumns = [JoinColumn(name = "id_turma")]
    )
    var classes: List<ClassEntity>? = null

//    @OneToOne(mappedBy = "student")
//    var chosenAlternative: AlternativeEntity? = null

    constructor(name: String, document: String, birthdate: String, classes: List<ClassEntity>) : this(name, document, LocalDate.parse(birthdate)){
        this.birthdate = LocalDate.parse(birthdate)
        this.classes = classes
    }
}