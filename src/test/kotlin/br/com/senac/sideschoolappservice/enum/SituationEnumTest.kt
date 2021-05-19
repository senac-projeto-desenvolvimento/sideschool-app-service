package br.com.senac.sideschoolappservice.enum

import br.com.senac.sideschoolappservice.data.entity.Student
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SituationEnumTest {

    lateinit var student: Student

    @Test
    fun testActiveSituation() {
        student = Student("Lucas", "222222", LocalDate.now())
        assertEquals(0, student.situation)
    }
}