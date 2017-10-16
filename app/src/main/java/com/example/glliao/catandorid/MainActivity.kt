package com.example.glliao.catandorid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var mEditUserName : EditText
    private lateinit var mEditPassword : EditText
    private lateinit var mBtnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    }
}
