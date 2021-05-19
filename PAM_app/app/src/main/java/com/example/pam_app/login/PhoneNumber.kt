package com.example.pam_app.login

open class PhoneNumber {
    @Throws(PhoneNumberException::class)
    open fun create(number: String): Boolean {
        try {
            // simulate saving the number on the database
            Thread.sleep(200)
        } catch (e: InterruptedException) {
            throw PhoneNumberException()
        }
        return true
    }

    internal class PhoneNumberException : Exception()
}
