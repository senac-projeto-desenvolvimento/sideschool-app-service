package br.com.senac.sideschoolappservice.controller

import br.com.senac.sideschoolappservice.data.*
import br.com.senac.sideschoolappservice.service.HomeworkService
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.*

@RestController
@ComponentScan
@EnableAutoConfiguration
@RequestMapping("/api/sideschool")
class HomeworkController(val homeworkService: HomeworkService) {

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

    @GetMapping("homework/{homeworkId}/question/{questionId}/alternatives")
    fun homework(@PathVariable homeworkId: Int, @PathVariable questionId: Int): Homework {
        val homework = homeworkService.loadHomework(homeworkId).get()
        val question = homeworkService.loadQuestion(questionId).get()
        val alternatives = homeworkService.loadAlternatives(question)

        return Homework.of(homework, question, alternatives)
    }
}