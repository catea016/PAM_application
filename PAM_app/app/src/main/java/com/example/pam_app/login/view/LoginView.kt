package com.example.pam_app.login.view

interface LoginView {
    fun onLoginSuccessful()

    fun showPhoneError(errorMessage: String?)

    fun showPasswordError(errorMessage: String?)

    fun requestPhoneFocus()

    fun requestPasswordFocus()
    fun hideProgress()
    fun showProgress()
}