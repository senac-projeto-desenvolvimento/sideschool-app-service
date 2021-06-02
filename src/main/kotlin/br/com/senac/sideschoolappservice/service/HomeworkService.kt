package br.com.senac.sideschoolappservice.service

import br.com.senac.sideschoolappservice.data.dto.AlternativeDto
import br.com.senac.sideschoolappservice.data.dto.HomeworkDto
import br.com.senac.sideschoolappservice.data.dto.QuestionDto
import br.com.senac.sideschoolappservice.data.entity.AlternativeEntity
import br.com.senac.sideschoolappservice.data.entity.HomeworkEntity
import br.com.senac.sideschoolappservice.data.entity.QuestionEntity
import br.com.senac.sideschoolappservice.data.entity.SubjectEntity
import br.com.senac.sideschoolappservice.repository.AlternativeRepository
import br.com.senac.sideschoolappservice.repository.HomeworkRepository
import br.com.senac.sideschoolappservice.repository.QuestionRepository
import br.com.senac.sideschoolappservice.repository.SubjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HomeworkService(
    @Autowired private val homeworkRepository: HomeworkRepository,
    @Autowired private val subjectRepository: SubjectRepository,
    @Autowired private val questionRepository: QuestionRepository,
    @Autowired private val alternativeRepository: AlternativeRepository) {

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


    fun saveHomework(homework: HomeworkDto) = homeworkRepository.save(convertDto(homework))
    fun saveQuestion(question: QuestionDto) = questionRepository.save(convertQuestionDto(question))
    fun saveAlternative(alternative: AlternativeDto) = alternativeRepository.save(convertAlternativeDto(alternative))


}