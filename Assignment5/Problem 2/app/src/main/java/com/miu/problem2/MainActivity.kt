package com.miu.problem2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class MainActivity : AppCompatActivity(), ProductAdapter.OnProductItemClickListener,
    ProductAdapter.OnProductAddClickListener {
    private val products = ArrayList<Product>()
    private lateinit var rvProduct: RecyclerView
    private val selectedItem = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateProducts()
        rvProduct = findViewById(R.id.rvList)
        val layoutManager = LinearLayoutManager(this)
        rvProduct.layoutManager = layoutManager
        rvProduct.adapter = ProductAdapter(products, this, this)
        val btnCart = findViewById<Button>(R.id.btnViewCart)

        btnCart.setOnClickListener {
            var output = "<<=== Item Selected ===>>\n"
            if(selectedItem.size>0) {
                for (item in selectedItem) {
                    var selectedItem = products[item]
                    output += "${selectedItem.productName}\n"
                }
            }
            else
            {
                output = "<<=== No item selected ===>>\n"
            }

            multilinetoast(output)
            //Toast.makeText(this@MainActivity, output, Toast.LENGTH_LONG).show()
        }
    }

    private fun populateProducts() {
        products.add(Product("iPad", "iPad Pro 11-inch", 400.0))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00))
        products.add(Product("Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.00))
        products.add(
            Product(
                "Logitech Keyboard",
                "Logitech - PRO X\nTKL LIGHTSPEED Wireless",
                199.00
            )
        )
        products.add(Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00))
    }

    private fun multilinetoast(message: String) {
        val inflater = layoutInflater
        val layout =
            inflater.inflate(R.layout.toast_multiline, findViewById(R.id.toast_layout_root))
        layout.findViewById<TextView>(R.id.tvMessage).text = message
        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }

    override fun onItemClick(position: Int) {
        var product = products[position]
        var intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra("product", product as Serializable)
        startActivity(intent)
    }

    override fun onButtonClick(position: Int) {
        if (!selectedItem.contains(position)) {
            selectedItem.add(position)
            Toast.makeText(this@MainActivity, "Item Selected", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "Item Already Exists", Toast.LENGTH_SHORT).show()
        }
    }
}