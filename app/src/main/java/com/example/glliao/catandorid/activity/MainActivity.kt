package com.example.glliao.catandorid.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.glliao.catandorid.R
import com.example.glliao.catandorid.presenter.LoginContract
import com.example.glliao.catandorid.presenter.LoginPresenter

class MainActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var mEditUserName : EditText
    private lateinit var mEditPassword : EditText
    private lateinit var mBtnLogin : Button

    private val TAG = "LoginActivity"
    private val presenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onStart")
        setContentView(R.layout.activity_main)
        mBtnLogin = findViewById(R.id.button_login)
        mEditUserName = findViewById(R.id.user_name)
        mEditPassword = findViewById(R.id.password)
        mBtnLogin.setOnClickListener{
            var userName = mEditUserName.editableText.toString()
            var password = mEditPassword.editableText.toString()
            Log.i("cat", "Button clicked!")
            Log.i("cat", userName + password)
        }

        mBtnLogin.setOnClickListener {
            presenter.startLogin(mEditUserName.text.toString(), mEditPassword.text.toString())
        }

    }

    override fun loginSuccess() {
        Log.d(TAG, "login successful!!!!")
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestory")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }
}
