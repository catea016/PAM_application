package com.example.pam_app.login.presenter

import com.example.pam_app.R
import com.example.pam_app.login.ResourceProvider
import com.example.pam_app.login.SchedulersFactory
import com.example.pam_app.login.model.LoginCredentials
import com.example.pam_app.login.model.LoginUseCase
import com.example.pam_app.login.model.LoginValidator
import com.example.pam_app.login.view.LoginView

class LoginPresenter(private val resourceProvider: ResourceProvider, private val loginValidator: LoginValidator,
                     private val loginUseCase: LoginUseCase, private val schedulersFactory: SchedulersFactory) : BasePresenter<LoginView>() {

    fun attemptLogin(loginCredentials: LoginCredentials) {
        if (!validateInputs(loginCredentials)) {
            return
        }

        view?.showProgress()
        loginUseCase.loginWithCredentialsWithStatus(loginCredentials)
            .compose(schedulersFactory.createMainThreadSchedulerTransformer())
            .subscribe { success ->
                view?.hideProgress()

                if (success) {
                    view?.onLoginSuccessful()
                } else {
                    view?.showPasswordError(resourceProvider.getString(R.string.error_incorrect_password))
                    view?.requestPasswordFocus()
                }
            }
    }

    private fun validateInputs(loginCredentials: LoginCredentials): Boolean {
        val validatePhone = validatePhone(loginCredentials)
        return validatePassword(loginCredentials) && validatePhone //XXX validateLogin is not inlined to avoid short circuit check
    }

    private fun validatePhone(loginCredentials: LoginCredentials): Boolean =
        if (loginValidator.validatePhone(loginCredentials.phone)) {
            view?.showPhoneError(null)
            true
        } else {
            view?.showPhoneError(resourceProvider.getString(R.string.error_field_required))
            view?.requestPhoneFocus()
            false
        }

    private fun validatePassword(loginCredentials: LoginCredentials): Boolean =
        if (loginValidator.validatePassword(loginCredentials.password)) {
            view?.showPasswordError(null)
            true
        } else {
            view?.showPasswordError(resourceProvider.getString(R.string.error_invalid_password))
            view?.requestPasswordFocus()
            false
        }
}