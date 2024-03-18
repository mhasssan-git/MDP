package com.miu.problem2

import java.io.Serializable

data class Product(val productName: String, val productDescription: String,
                   val cost: Double) : Serializable


data class ProductImage(val productIcon: Int, val productLogo: Int)