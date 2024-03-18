package com.miu.EcommerceApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.io.Serializable

class SignupActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etPwd: EditText
    lateinit var etRetypePwd: EditText
    lateinit var btnSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        initView()
        btnSubmit.setOnClickListener { vw -> signUp(vw) }
    }

    private fun initView() {
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPwd = findViewById(R.id.etPwd)
        etRetypePwd = findViewById(R.id.etReTypePwd)
        btnSubmit = findViewById(R.id.btnSignup)
    }

    private fun signUp(view: View) {
        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val pwd = etPwd.text.toString()
        val rePwd = etRetypePwd.text.toString()

        if (name == "") {
            validateControl(etName)
        }
        if (email == "") {
            validateControl(etEmail)
        }
        if (pwd == "") {
            validateControl(etPwd)
        }
        if (rePwd == "") {
            validateControl(etRetypePwd)
        }
        if (pwd != rePwd) {
            validateControl(etPwd,"Password and Retype password don't match")
        }
        if (name != "" && email != "" && pwd != "" && rePwd != "" && pwd == rePwd) {
            val user=User(name, email, pwd)
            val isSuccess=UserDb.addUser(user, this)
            if(isSuccess)
            {
                val intent = Intent(this, ShoppingCategoryActivity::class.java)
                intent.putExtra("user",user as Serializable)
                startActivity((intent))
            }
        }
    }
    private fun validateControl(view: EditText,error:String="This field is required") {
        view.error = error
        //view.setBackgroundResource(R.drawable.error_drawable)
    }
}