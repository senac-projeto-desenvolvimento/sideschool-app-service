package br.com.senac.sideschoolappservice.student

import br.com.senac.sideschoolappservice.data.entity.Student
import br.com.senac.sideschoolappservice.repository.StudentRepository
import br.com.senac.sideschoolappservice.service.ClassService
import br.com.senac.sideschoolappservice.service.StudentService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentTest {

    //TODO: implementar testes para studentsService
//    @Test
//    fun saveStudentTest() {
//        val student = Student("teste1", "54545454", LocalDate.now())
//        val studentService = Mockito.mock(StudentService::class.java)
//
//        Mockito.`when`(studentService.save(Student("test", "54545454", LocalDate.now())))
//            .thenReturn(student)
//        val name = studentService.save(student).name
//        Assertions.assertEquals("teste1", name)
//    }
}