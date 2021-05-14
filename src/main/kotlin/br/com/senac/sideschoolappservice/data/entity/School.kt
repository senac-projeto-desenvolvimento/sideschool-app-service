package br.com.senac.sideschoolappservice.data.entity

import javax.persistence.*

@Entity(name = "escola")
class School(var name: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escola")
    var schoolId: Int = 0

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var classes : MutableList<Class>  = ArrayList()
}