package com.example.pam_app.login.model

class LoginValidator {
    companion object {
        val EMPTY = ""
        val MIN_PASSWORD_LENGTH = 6
    }

    fun validatePhone(phone: String): Boolean {
        return phone != EMPTY
    }

    fun validatePassword(password: String): Boolean {
        return password.length >= MIN_PASSWORD_LENGTH
    }
}