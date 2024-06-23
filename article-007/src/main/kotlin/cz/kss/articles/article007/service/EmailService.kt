package cz.kss.articles.article007.service

interface EmailService {
    fun sendEmail(email: String, subject: String, message: String)
}