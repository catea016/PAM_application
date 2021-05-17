package com.example.pam_app.login

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.pam_app.databinding.ActivityLoginBinding
import com.example.pam_app.login.model.LoginCredentials
import com.example.pam_app.login.model.LoginRepository
import com.example.pam_app.login.model.LoginUseCase
import com.example.pam_app.login.model.LoginValidator
import com.example.pam_app.login.presenter.LoginPresenter
import com.example.pam_app.login.view.LoginView


class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var numberSaverHelper: NumberSaverHelper
    lateinit var loginPresenter: LoginPresenter

    lateinit var password: EditText
    lateinit var phoneNumber: EditText
    lateinit var progressView: View
    lateinit var loginFormView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        password = binding.password
        phoneNumber = binding.phone
        progressView = binding.loginProgress
        loginFormView = binding.loginForm

        onSignInClick()

        loginPresenter = LoginPresenter(
            ResourceProvider(resources), LoginValidator(),
            LoginUseCase(LoginRepository()), SchedulersFactory()
        )
        loginPresenter.createView(this)

    }

    override fun onDestroy() {
        loginPresenter.destroyView()
        super.onDestroy()
    }


    private fun onSignInClick() {
        binding.signInButton.setOnClickListener {
            loginPresenter.attemptLogin(
                LoginCredentials(
                    phone = phoneNumber.text.toString(),
                    password = password.text.toString()
                )
            )
        }
    }

    override fun showProgress() {
        showProgress(true)
    }

    override fun hideProgress() {
        showProgress(false)
    }

    override fun onLoginSuccessful() {
        finish()
    }

    override fun showPhoneError(errorMessage: String?) {
        phoneNumber.error = errorMessage
    }

    override fun showPasswordError(errorMessage: String?) {
        password.error = errorMessage
    }

    override fun requestPhoneFocus() {
        phoneNumber.requestFocus()
    }

    override fun requestPasswordFocus() {
        password.requestFocus()
    }

    internal fun showProgress(progressVisible: Boolean) {
        val animationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)

        loginFormView.visibility = if (progressVisible) View.GONE else View.VISIBLE
        loginFormView.animate().setDuration(animationDuration.toLong())
            .alpha((if (progressVisible) 0 else 1).toFloat())

        progressView.visibility = if (progressVisible) View.VISIBLE else View.GONE
        progressView.animate().setDuration(animationDuration.toLong())
            .alpha((if (progressVisible) 1 else 0).toFloat())
    }
}