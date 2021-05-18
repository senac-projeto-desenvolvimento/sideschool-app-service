package br.com.senac.sideschoolappservice.service

import org.springframework.context.MessageSourceResolvable

abstract class HomeworkException : RuntimeException, MessageSourceResolvable {

    constructor(message: String) : super(message) { }
    constructor(message: String, cause: Throwable) : super(message, cause) { }

    class HomeworkCreationException(message: String) : HomeworkException(message) {

        override fun getCodes(): Array<out String> = arrayOf("HomeworkCreationException")
    }

    class SchoolCreationException(message: String) : HomeworkException(message) {

        override fun getCodes(): Array<out String> = arrayOf("HomeworkCreationException")
    }
}