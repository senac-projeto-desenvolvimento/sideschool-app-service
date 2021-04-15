package br.com.senac.sideschoolappservice

import br.com.senac.sideschoolappservice.controller.HomeWorkController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SideschoolAppServiceApplicationTests {

	@InjectMocks
	lateinit var homeWorkController: HomeWorkController

	@Test
	fun contextLoads() {
		val result = homeWorkController.getHomeWork()
		Assertions.assertNotNull(result)
		Assertions.assertEquals("homework oh yeah", result)
	}

}
