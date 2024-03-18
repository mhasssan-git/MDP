package com.miu.EcommerceApp

import android.content.Context
import android.widget.Toast
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

object UserDb {
    private var list = ArrayList<User>()

    init {

    }

    fun addUser(user: User,context:Context): Boolean {
        var ifExists = list
            .stream()
            .anyMatch { t -> t.email == user.email }
        if (!ifExists) {
            list.add(user)
            return true;
        } else {
            Toast.makeText(context,"User Already Exists",Toast.LENGTH_SHORT).show()
            return false
        }
    }

    fun getUser(email: String): User? {
        var user =
            list.stream().filter { t -> t.email == email }.findAny()
        return user.getOrNull()
    }
}