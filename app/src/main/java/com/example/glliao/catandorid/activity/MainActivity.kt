package com.example.glliao.catandorid.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import com.example.glliao.catandorid.R
import com.example.glliao.catandorid.presenter.LoginContract
import com.example.glliao.catandorid.presenter.LoginPresenter

class MainActivity : AppCompatActivity(), LoginContract.View {

    @BindView(R.id.button_login)
    lateinit var mBtnLogin: Button

    @BindView(R.id.user_name)
    lateinit var mEditUserName: EditText

    @BindView(R.id.password)
    lateinit var mEditPassword: EditText

    private val TAG = "LoginActivity"
    private val presenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onStart")
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        mBtnLogin.setOnClickListener {
            presenter.startLogin(mEditUserName.text.toString(), mEditPassword.text.toString())
        }

    }

    override fun loginSuccess() {
        Log.d(TAG, "login successful!!!!")
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
