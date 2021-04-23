package br.com.senac.sideschoolappservice

import br.com.senac.sideschoolappservice.service.HomeWorkService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SideschoolAppServiceApplicationTests {

	@InjectMocks
	lateinit var homeWorkService: HomeWorkService

	@Test
	fun homeWorkShouldHaveRightAnswer() {
		val result = homeWorkService.getHomework()
		Assertions.assertNotNull(result)
		Assertions.assertEquals("A", result.questions[0].rightAnswer)
	}

	@Test
	fun homeWorkShouldHaveAlternatives() {
		val result = homeWorkService.getHomework()
		Assertions.assertNotNull(result.questions[0].alternatives)
		Assertions.assertEquals("A", result.questions[0].alternatives[0])
	}

}
