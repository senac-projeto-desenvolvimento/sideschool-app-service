package br.com.senac.sideschoolappservice.question

import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomeworkConverterTest {
//
//    @Autowired
//    lateinit var homeworkConverter: HomeworkConverter
//
//    @Test
//    fun shouldConvertDtotoEntity() {
//
////        val alternativesA = listOf<AlternativeDto>(
////            AlternativeDto(1, "1", 0), AlternativeDto(2, "2", 1),
////            AlternativeDto(3, "3", 0), AlternativeDto(4, "5", 0)
////        )
////        val alternativesB = listOf<AlternativeDto>(
////            AlternativeDto(5, "Azul", 1), AlternativeDto(6, "Vermelho", 0),
////            AlternativeDto(7, "Verde", 0), AlternativeDto(8, "Laranja", 0)
////        )
////        val questionA = QuestionDto(1, "Quanto é 1 + 1?", alternativesA)
////
////        val homework = homeworkConverter.convertDtoToEntity(HomeworkDto(1, "teste", listOf(questionA), 2))
////
////        println(homework.createdDate)
////        println(homework.subject.title)
////        Assertions.assertNotNull(homework.createdDate)
//    }
//
//    @Test
//    fun shouldConvertEntitytoDto() {
////
////        val alternativesA = listOf<AlternativeDto>(
////            AlternativeDto(1, "1", 0), AlternativeDto(2, "2", 1),
////            AlternativeDto(3, "3", 0), AlternativeDto(4, "5", 0)
////        )
////        val alternativesB = listOf<AlternativeDto>(
////            AlternativeDto(5, "Azul", 1), AlternativeDto(6, "Vermelho", 0),
////            AlternativeDto(7, "Verde", 0), AlternativeDto(8, "Laranja", 0)
////        )
////        val questionA = QuestionDto(1, "Quanto é 1 + 1?", alternativesA)
////        val questionB = QuestionDto(2, "Qual a cor do céu?", alternativesB)
////
////        val homework = homeworkConverter.convertDtoToEntity(HomeworkDto(1, "teste", listOf(questionA), 1))
////
////        Assertions.assertNotNull(homework.createdDate)
//    }

}