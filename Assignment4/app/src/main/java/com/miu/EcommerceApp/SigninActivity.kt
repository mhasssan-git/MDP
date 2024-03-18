package com.miu.EcommerceApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.Serializable

class SigninActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var chkShowPwd: CheckBox
    lateinit var btnSignin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        initView()
        btnSignin.setOnClickListener { v -> btn_signin_click(v) }
        chkShowPwd.setOnClickListener { v ->
            var chk = v as CheckBox
            if (chk.isChecked) {
                etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }

    fun initView() {
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPwd)
        chkShowPwd = findViewById(R.id.chkShowPwd)
        btnSignin = findViewById(R.id.btnSignin)
    }

    fun btn_signin_click(view: View) {
        val email = etEmail.text.toString()
        val pwd = etPassword.text.toString()
        if (email == "")
            validateControl(etEmail)
        if (pwd == "")
            validateControl(etPassword)
        if (email != "" && pwd != "") {
            val user = UserDb.getUser(email)

            if (user != null) {
                if (user.password != pwd) {
                    Toast.makeText(
                        this@SigninActivity,
                        "Password doesn't match, Please provide valid password",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    val intent = Intent(this, ShoppingCategoryActivity::class.java)
                    intent.putExtra("user", user as Serializable)
                    startActivity((intent))
                }
            } else {
                Toast.makeText(
                    this@SigninActivity,
                    "User not found, please create an account",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun btn_signup_click(view: View) {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity((intent))
    }

    private fun validateControl(view: EditText, error: String = "This field is required") {
        view.error = error
    }
}