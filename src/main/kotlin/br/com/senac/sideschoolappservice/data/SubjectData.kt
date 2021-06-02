package br.com.senac.sideschoolappservice.data

import br.com.senac.sideschoolappservice.data.entity.SubjectEntity

data class SubjectData(val subjectId: Int?
                      , val title: String,
                        val classes: List<Int>?) {
    companion object {
        fun of(source: SubjectEntity) = SubjectData(source.subjectId, source.title, source.classes?.map { it.classId})
    }
}
