package com.example.pam_app.login.presenter

internal interface Presenter<in T> {

    fun createView(view: T)

    fun destroyView()
}
