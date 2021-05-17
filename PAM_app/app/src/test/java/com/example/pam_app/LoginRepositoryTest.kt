package com.example.pam_app

import com.example.pam_app.login.model.LoginRepository
import com.example.pam_app.login.model.LoginRepository.Companion.CORRECT_PASSWORD
import com.example.pam_app.login.model.LoginRepository.Companion.CORRECT_PHONE
import org.junit.Test

class LoginRepositoryTest {
    val objectUnderTest = LoginRepository()

    @Test
    fun `login with correct phone number and password`() {
        //given
        val phone = CORRECT_PHONE
        val password = CORRECT_PASSWORD
        //when
        val result = objectUnderTest.login(phone, password)
        //then
        result.test().await()
            .assertResult(true)
    }

    @Test
    fun `do not login with only correct phone number`() {
        //given
        val phone = CORRECT_PHONE
        val password = "anyPassword"
        //when
        val result = objectUnderTest.login(phone, password)
        //then
        result.test().await()
            .assertResult(false)
    }

    @Test
    fun `do not login with only correct password`() {
        //given
        val phone = "0827261725"
        val password = CORRECT_PASSWORD
        //when
        val result = objectUnderTest.login(phone, password)
        //then
        result.test().await()
            .assertResult(false)
    }
}