package com.miu.EcommerceApp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

class ShoppingCategoryActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category_activy)
        val user = intent.extras?.getSerializable("user", User::class.java)
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        tvWelcome.text = "Welcome ${user?.name}"
    }

    fun onItemClicked(view: View) {
        val data = view.tag as String
        val message="You have selected Category \"$data\" !!"
        Toast.makeText(this@ShoppingCategoryActivity,message,Toast.LENGTH_SHORT).show()
    }
}