package br.com.senac.sideschoolappservice.controller

import br.com.senac.sideschoolappservice.data.dto.AlternativeDto
import br.com.senac.sideschoolappservice.data.dto.HomeworkDto
import br.com.senac.sideschoolappservice.data.dto.QuestionDto
import br.com.senac.sideschoolappservice.data.dto.SubmitHomeworkDto
import br.com.senac.sideschoolappservice.data.entity.AlternativeEntity
import br.com.senac.sideschoolappservice.data.entity.Student
import br.com.senac.sideschoolappservice.data.response.*
import br.com.senac.sideschoolappservice.service.ClassService
import br.com.senac.sideschoolappservice.service.HomeworkService
import br.com.senac.sideschoolappservice.service.StudentService
import br.com.senac.sideschoolappservice.service.SubjectService
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("/api/sideschool")
class HomeworkController(
    val homeworkService: HomeworkService,
    val studentService: StudentService,
    val classService: ClassService,
    val subjectService: SubjectService) {

    @GetMapping("subject/{subjectId}/homework")
    fun getAllHomeworksBySubject(@PathVariable subjectId: Int) : List<HomeworkData> {
        val subject = homeworkService.loadSubject(subjectId).get()

        return homeworkService.loadHomeworks(subject).map { HomeworkData.of(it) }
    }

    @GetMapping("subject/{subjectId}")
    fun getSubjectById(@PathVariable subjectId: Int) : SubjectData = SubjectData.of(homeworkService.loadSubject(subjectId).get())

    @PostMapping("subject/{subjectId}/homework")
    fun saveHomework(@PathVariable subjectId: Int, @RequestBody body: HomeworkDto): HomeworkData {
        body.subject = homeworkService.loadSubject(subjectId).get()

        return HomeworkData.of(homeworkService.saveHomework(body))
    }

    @PostMapping("homework/{homeworkId}/question")
    fun saveQuestion(@PathVariable homeworkId: Int, @RequestBody body: QuestionDto): QuestionData {
        body.homework = homeworkService.loadHomework(homeworkId).get()

        return QuestionData.of(homeworkService.saveQuestion(body))
    }

    @GetMapping("homework/{homeworkId}/question")
    fun getQuestions(@PathVariable homeworkId: Int): List<QuestionData> {
        val homework = homeworkService.loadHomework(homeworkId).get()

        return homeworkService.loadQuestions(homework).map { QuestionData.of(it) }
    }

    @GetMapping("question/{questionId}/alternative")
    fun getAlternatives(@PathVariable questionId: Int): List<AlternativeData> {
        val question = homeworkService.loadQuestion(questionId).get()

        return homeworkService.loadAlternatives(question).map { AlternativeData.of(it) }
    }

    @PostMapping("question/{questionId}/alternative")
    fun saveAlternative(@PathVariable questionId: Int, @RequestBody body: AlternativeDto): AlternativeData {
        body.question = homeworkService.loadQuestion(questionId).get()

        return AlternativeData.of(homeworkService.saveAlternative(body))
    }

    @GetMapping("homework/{homeworkId}/result")
    fun result(@RequestHeader studentId: Int, @PathVariable homeworkId: Int): StudentHomeworkResult {
        val questions = homeworkService.loadQuestionsByHomeworkId(homeworkId)
        val rightAnswers: List<AlternativeEntity> = questions
            .flatMap { homeworkService.loadAlternatives(it) }
            .filter { it.rightAnswer == 1 }

        val studentAnswers = questions
            .map { homeworkService.findStudentResult(it.questionId, studentId) }
            .filter {
                it.answerId in rightAnswers.map { it.answerId }
            }
        val wrongAnswers = questions.size - studentAnswers.size

        return StudentHomeworkResult(studentAnswers.size, wrongAnswers)
    }

    @GetMapping("homework/home")
    fun getHomeworkByStudent(@RequestHeader studentId: Int): List<HomeworkData> {
        val student = studentService.findById(studentId)
        val classFound = classService.findByStudent(student)
        val subject = subjectService.findAllByClass(classFound)

        return subject.flatMap { sub ->
            homeworkService.loadHomeworks(sub).map { homework -> HomeworkData.of(homework) }
        }
    }

    @GetMapping("homework/{homeworkId}")
    fun homework(@PathVariable homeworkId: Int): HomeworkResponse {
        val homework = homeworkService.loadHomework(homeworkId).get()
        val questions = homeworkService.loadQuestions(homework)

        return HomeworkResponse.of(homework, questions)
    }

    @PostMapping("/homework/{homeworkId}/submit")
    fun submitHomework(@PathVariable homeworkId: Int, @RequestBody submit: SubmitHomeworkDto) {
        val homework = homeworkService.loadHomework(homeworkId).get()
        val questions = homeworkService.loadQuestions(homework)
        val alternatives: List<AlternativeEntity> = questions
            .flatMap { homeworkService.loadAlternatives(it) }

        val chosenAlternatives: List<AlternativeEntity> = alternatives
            .filter { it.answerId in submit.alternativesId }
            .distinctBy { Pair(it.answerId, it.question)}

        val student: Student = studentService.findById(submit.studentId)
        chosenAlternatives.map { it.student = student }

        homeworkService.submitHomework(chosenAlternatives)
    }
}