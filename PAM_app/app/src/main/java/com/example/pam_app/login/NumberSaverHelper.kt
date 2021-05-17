package com.example.pam_app.login

class NumberSaverHelper {
    private var phoneNumber: PhoneNumber? = null

     constructor (phoneNumber: PhoneNumber?) {
        this.phoneNumber = phoneNumber
    }
    constructor()

    @Throws(PhoneNumber.PhoneNumberException::class)
    fun savePhoneNumber(number: String): Boolean {
        var phoneCreated = false
        if (isValidNumber(number)) {
            phoneCreated = phoneNumber!!.create(number)
        }
        return phoneCreated
    }

    private fun isValidNumber(number: String): Boolean {
        return if (number.length < 9) {
            false
        } else number.toString().length == 9
    }
}