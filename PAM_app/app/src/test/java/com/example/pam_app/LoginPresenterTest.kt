package com.example.pam_app
import android.content.res.Resources
import com.example.pam_app.login.ResourceProvider
import com.example.pam_app.login.SchedulersFactory
import com.example.pam_app.login.model.LoginCredentials
import com.example.pam_app.login.model.LoginRepository
import com.example.pam_app.login.model.LoginUseCase
import com.example.pam_app.login.model.LoginValidator
import com.example.pam_app.login.presenter.LoginPresenter
import com.example.pam_app.login.view.LoginView
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.BDDMockito.given
import org.mockito.Mockito.*

class LoginPresenterTest {
    val loginViewMock: LoginView = mock(LoginView::class.java)
    val resourcesStub: Resources = mock(Resources::class.java)
    val schedulersFactoryStub: SchedulersFactory = mock(SchedulersFactory::class.java)
    val loginRepositoryStub = mock(LoginRepository::class.java)

    val objectUnderTest = LoginPresenter(ResourceProvider(resourcesStub), LoginValidator(), LoginUseCase(loginRepositoryStub), schedulersFactoryStub)

    @Before
    fun setUp() {
        removeObserveOnMainThreadScheduler()
        objectUnderTest.createView(loginViewMock)
    }

    @Test
    fun `login with correct data`() {
        //given
        given(loginRepositoryStub.login(anyString(), anyString())).willReturn(Observable.just(true))
        //when
        objectUnderTest.attemptLogin(LoginCredentials(phone = "068188035", password = "password"))
        //then
        verify(loginViewMock).onLoginSuccessful()
    }

    @Test
    fun `login with correct data with progress indication`() {
        //given
        given(loginRepositoryStub.login(anyString(), anyString())).willReturn(Observable.just(true))
        //when
        objectUnderTest.attemptLogin(LoginCredentials(phone = "068188035", password = "password"))
        //then
        val ordered = inOrder(loginViewMock)
        ordered.verify(loginViewMock).showProgress()
        ordered.verify(loginViewMock).hideProgress()
    }

    @Test
    fun `login with valid but incorrect data`() {
        //given
        given(resourcesStub.getString(anyInt())).willReturn("error")
        given(loginRepositoryStub.login(anyString(), anyString())).willReturn(Observable.just(false))
        //when
        objectUnderTest.attemptLogin(LoginCredentials(phone = "069353321", password = "incorrectPassword"))
        //then
        val ordered = inOrder(loginViewMock)
        ordered.verify(loginViewMock).showPhoneError(null)
        ordered.verify(loginViewMock).showPasswordError("error")
    }

    @Test
    fun `show validation error for empty phone`() {
        //given
        given(resourcesStub.getString(anyInt())).willReturn("error")
        val phone = ""
        //when
        objectUnderTest.attemptLogin(LoginCredentials(phone = phone, password = "validPassword"))
        //then
        verify(loginViewMock).showPhoneError("error")
        verify(loginViewMock).showPasswordError(null)
    }

    @Test
    fun `show validation error for empty phone and too short password`() {
        //given
        given(resourcesStub.getString(anyInt())).willReturn("error")
        val phone = ""
        val password = "short"
        //when
        objectUnderTest.attemptLogin(LoginCredentials(phone = phone, password = password))
        //then
        verify(loginViewMock).showPhoneError("error")
        verify(loginViewMock).showPasswordError("error")
    }

    @Test
    fun `show validation error for too short password`() {
        //given
        given(resourcesStub.getString(anyInt())).willReturn("error")
        val password = "short"
        //when
        objectUnderTest.attemptLogin(LoginCredentials(phone = "valid", password = password))
        //then
        verify(loginViewMock).showPhoneError(null)
        verify(loginViewMock).showPasswordError("error")
    }

    private fun removeObserveOnMainThreadScheduler() {
        given(schedulersFactoryStub.createMainThreadSchedulerTransformer<Boolean>()).willReturn(ObservableTransformer { it })
    }
}