package com.miu.problem2

import android.accounts.AuthenticatorDescription
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import org.w3c.dom.Text
import java.text.DecimalFormat

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var tvProductName: TextView
    private lateinit var tvProductDescription: TextView
    private lateinit var tvPrice: TextView
    private lateinit var btnHome: Button
    lateinit var imView:ImageView

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val product = intent.extras?.getSerializable("product", Product::class.java)
        tvProductName = findViewById(R.id.tvProductName)
        tvProductDescription = findViewById(R.id.tvProductDescription)
        tvPrice = findViewById(R.id.tvPrice)
        btnHome = findViewById(R.id.btnHome)
        imView=findViewById(R.id.imageView)
        tvProductName.text = product?.productName
        tvProductDescription.text = product?.productDescription
        val price = String.format("%.2f", product?.cost)
        tvPrice.text = "$ $price"
        btnHome.setOnClickListener {
            val intent = Intent(
                this@ProductDetailsActivity,
                MainActivity::class.java
            )
            startActivity(intent)
        }
       var icon= product?.productName?.let { ProductAdapter.resolveIcon(it) }
        if (icon != null) {
            imView.setImageResource(icon.productIcon)
        }

    }
}