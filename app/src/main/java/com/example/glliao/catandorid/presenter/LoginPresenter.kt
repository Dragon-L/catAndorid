package com.example.glliao.catandorid.presenter

import android.text.TextUtils
import android.util.Log
import android.view.View

class LoginPresenter(private val loginView: LoginContract.View) : LoginContract.Presenter {
    private val TAG = "LoginPresenter"

    override fun startLogin(userName: String, password: String) {
        Log.d(TAG, "Username: $userName, Password: $password")
        if (validateAccount(userName, password)) {
            loginView.loginSuccess()
        }

    }

    private fun validateAccount(userName: String, password: String): Boolean {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            Log.d(TAG, "your username or password is empty")
            return false
        }
        return true
    }
}