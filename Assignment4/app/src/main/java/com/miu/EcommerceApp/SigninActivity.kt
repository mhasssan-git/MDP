package com.miu.EcommerceApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
    }

    fun btn_signin_click(view: View) {

    }

    fun btn_signup_click(view: View) {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity((intent))
    }
}