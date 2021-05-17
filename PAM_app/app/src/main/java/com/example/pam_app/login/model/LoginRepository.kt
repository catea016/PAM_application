package com.example.pam_app.login.model
import io.reactivex.Observable
import io.reactivex.Observable.fromCallable
import timber.log.Timber
import java.util.concurrent.TimeUnit

class LoginRepository {
    fun login(phone: String, password: String): Observable<Boolean> {
        Timber.v("login %s with password %s", phone, password)

        return fromCallable { CORRECT_PHONE == phone && CORRECT_PASSWORD == password }
            .delay(2000, TimeUnit.MILLISECONDS)
    }

    companion object {
        internal val CORRECT_PHONE = "068188035"
        internal val CORRECT_PASSWORD = "password"
    }
}