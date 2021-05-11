package br.com.senac.sideschoolappservice

import br.com.senac.sideschoolappservice.data.AlternativeDto
import br.com.senac.sideschoolappservice.data.HomeworkDto
import br.com.senac.sideschoolappservice.data.QuestionDto
import br.com.senac.sideschoolappservice.data.converter.HomeworkConverter
import br.com.senac.sideschoolappservice.data.entity.AlternativeEntity
import br.com.senac.sideschoolappservice.data.entity.HomeworkEntity
import br.com.senac.sideschoolappservice.data.entity.QuestionEntity
import br.com.senac.sideschoolappservice.repository.HomeworkRepository
import br.com.senac.sideschoolappservice.service.HomeworkService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import java.sql.Date

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomeworkTests {

//	@Mock
//	lateinit var homeworkRepository: HomeworkRepository
//
//	@Mock
//	lateinit var homeworkConverter: HomeworkConverter
//
//	@InjectMocks
//	lateinit var homeworkService: HomeworkService

//	@BeforeEach
//	fun setupHomework() {
//		val alternativesA = listOf<AlternativeDto>(
//			AlternativeDto(1, "1", 0), AlternativeDto(2, "2", 1),
//			AlternativeDto(3, "3", 0), AlternativeDto(4, "5", 0)
//		)
//		val alternativesB = listOf<AlternativeDto>(
//			AlternativeDto(5, "Azul", 1), AlternativeDto(6, "Vermelho", 0),
//			AlternativeDto(7, "Verde", 0), AlternativeDto(8, "Laranja", 0)
//		)
//		val questionA = QuestionDto(1, "Quanto é 1 + 1?", alternativesA)
//		val questionB = QuestionDto(2, "Qual a cor do céu?", alternativesB)
//
//		Mockito.`when`(homeworkService.getAllHomework())
//			.thenReturn(listOf<HomeworkDto>(HomeworkDto(1, "", listOf<QuestionDto>(questionA, questionB), 1)))
////
////		val alternativesA = listOf<AlternativeEntity>(
////			AlternativeEntity("1", 0), AlternativeEntity("2", 1),
////			AlternativeEntity("3", 0), AlternativeEntity("4", 0)
////		)
////		val alternativesB = listOf<AlternativeEntity>(
////			AlternativeEntity("Azul", 1), AlternativeEntity("Vermelho", 0),
////			AlternativeEntity("Verde", 0), AlternativeEntity("Laranja", 0)
////		)
////		val questionA = QuestionEntity("1", alternativesA)
////		val questionB = QuestionEntity("Qual a cor do céu?", alternativesB)
////
////		Mockito.`when`(homeworkService.getAllHomework())
////			.thenReturn(listOf<HomeworkEntity>(HomeworkEntity(listOf<QuestionEntity>(questionA, questionB), "teste", Date(1))))
	//}

//	@Test
//	fun homeWorkShouldHaveRightAnswer() {
//		val result = homeworkService.getHomework()
//		Assertions.assertNotNull(result)
//	}
//
//	@Test
//	fun homeWorkShouldHaveAlternatives() {
//		val result = homeworkService.getHomework()
//		Assertions.assertNotNull(result.questions[0].alternatives)
//		Assertions.assertEquals(0, result.questions[0].alternatives[0].rightAnswer)
//	}
//
//	@Test
//	fun homeWorkShouldHaveQuestions() {
//		val result = homeworkService.getAllHomework()
//		Assertions.assertNotNull(result[0].questions[0])
//	}

}
