package br.com.senac.sideschoolappservice.service

import br.com.senac.sideschoolappservice.data.dto.AlternativeDto
import br.com.senac.sideschoolappservice.data.dto.HomeworkDto
import br.com.senac.sideschoolappservice.data.dto.QuestionDto
import br.com.senac.sideschoolappservice.data.entity.*
import br.com.senac.sideschoolappservice.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HomeworkService(
    private val homeworkRepository: HomeworkRepository,
    private val subjectRepository: SubjectRepository,
    private val questionRepository: QuestionRepository,
    private val alternativeRepository: AlternativeRepository,
    private val studentAlternativeRepository: StudentAlternativeRepository) {

    fun convertDto(homework: HomeworkDto): HomeworkEntity = HomeworkEntity(homework.description,
        homework.subject ?: throw HomeworkException.HomeworkCreationException("Subject doesn't exist"))

    fun convertQuestionDto(question: QuestionDto): QuestionEntity = QuestionEntity(question.description,
        question.homework ?: throw HomeworkException.HomeworkCreationException("Homework doesn't exist"))

    fun convertAlternativeDto(alternative: AlternativeDto): AlternativeEntity = AlternativeEntity(alternative.answer, alternative.rightAnswer,
        alternative.question ?: throw HomeworkException.HomeworkCreationException("Homework doesn't exist"))

    fun loadSubject(subjectId: Int) = subjectRepository.findById(subjectId)

    fun loadHomework(homeworkId: Int) = homeworkRepository.findById(homeworkId)
    fun loadHomeworks(subject: SubjectEntity) = homeworkRepository.findBySubject(subject)

    fun loadQuestions(homework: HomeworkEntity) = questionRepository.findByHomework(homework)
    fun loadQuestion(questionId: Int) = questionRepository.findById(questionId)

    fun loadAlternatives(question: QuestionEntity) = alternativeRepository.findByQuestion(question)
    fun findAlternativeById(alternativeId: Int) = alternativeRepository.findById(alternativeId)

    fun saveHomework(homework: HomeworkDto) = homeworkRepository.save(convertDto(homework))
    fun saveQuestion(question: QuestionDto) = questionRepository.save(convertQuestionDto(question))
    fun saveAlternative(alternative: AlternativeDto) = alternativeRepository.save(convertAlternativeDto(alternative))
    fun submitHomework(alternatives: List<AlternativeEntity>)  {
        alternatives.forEach { alternative -> studentAlternativeRepository.submitHomework(alternative) }
    }
}