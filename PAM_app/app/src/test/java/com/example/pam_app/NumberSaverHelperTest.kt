package com.example.pam_app

import com.example.pam_app.login.NumberSaverHelper
import com.example.pam_app.login.PhoneNumber
import org.junit.Assert
import org.junit.Test


class NumberSaverHelperTest {

    private val SHORT_NUMBER = "12345678"
    private val LONG_NUMBER = "1234567890"
    private val CORRECT_NUMBER = "123456789"


    @Test
    @Throws(PhoneNumber.PhoneNumberException::class)
    fun shouldReturnFalseForShortNumbers() {
        val numberSaverHelper = givenNumberSaverHelperWithSucess()
        val result = numberSaverHelper.savePhoneNumber(SHORT_NUMBER)
        Assert.assertFalse(result)
    }

    @Test
    @Throws(PhoneNumber.PhoneNumberException::class)
    fun shouldReturnFalseForLongNumbers() {
        val numberSaverHelper = givenNumberSaverHelperWithSucess()
        val result = numberSaverHelper.savePhoneNumber(LONG_NUMBER)
        Assert.assertFalse(result)
    }

    @Test
    @Throws(PhoneNumber.PhoneNumberException::class)
    fun shouldReturnTrueForCorrect() {
        val numberSaverHelper = givenNumberSaverHelperWithSucess()
        val result = numberSaverHelper.savePhoneNumber(CORRECT_NUMBER)
        Assert.assertTrue(result)
    }

    @Test
    @Throws(PhoneNumber.PhoneNumberException::class)
    fun shouldReturnFalseWhenClassReturnFalse() {
        val numberSaverHelper = givenNumberSaverHelperWithError()
        val result = numberSaverHelper.savePhoneNumber(CORRECT_NUMBER)
        Assert.assertFalse(result)
    }

    @Test(expected = PhoneNumber.PhoneNumberException::class)
    @Throws(PhoneNumber.PhoneNumberException::class)
    fun shouldThrowExceptionFromClass() {
        val numberSaverHelper = givenNumberSaverHelperWithExceptionInClass()
        val result = numberSaverHelper.savePhoneNumber(CORRECT_NUMBER)
        Assert.assertTrue(result)
    }

    private fun givenNumberSaverHelperWithSucess(): NumberSaverHelper {
        val phoneNumber: PhoneNumberMocked = PhoneNumberMocked(true)
        return NumberSaverHelper(phoneNumber)
    }

    private fun givenNumberSaverHelperWithError(): NumberSaverHelper {
        val phoneNumber: PhoneNumberMocked = PhoneNumberMocked(false)
        return NumberSaverHelper(phoneNumber)
    }

    private fun givenNumberSaverHelperWithExceptionInClass(): NumberSaverHelper {
        val phoneNumber: PhoneNumberMocked = PhoneNumberMocked(true)
        phoneNumber.setForceException(true)
        return NumberSaverHelper(phoneNumber)
    }

    internal inner class PhoneNumberMocked(private val mockedReturn: Boolean) :
        PhoneNumber() {
        private var forceException = false
        @Throws(PhoneNumberException::class)
        override fun create(number: String): Boolean {
            if (forceException) {
                throw PhoneNumberException()
            }
            return mockedReturn
        }

        fun setForceException(forceException: Boolean) {
            this.forceException = forceException
        }
    }

}