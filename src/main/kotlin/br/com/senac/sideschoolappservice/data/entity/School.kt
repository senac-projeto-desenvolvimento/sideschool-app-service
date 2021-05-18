package br.com.senac.sideschoolappservice.data.entity

import javax.persistence.*

@Entity(name = "escola")
class School(@Column(name = "nome_escola") var name: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escola")
    var schoolId: Int = 0

}