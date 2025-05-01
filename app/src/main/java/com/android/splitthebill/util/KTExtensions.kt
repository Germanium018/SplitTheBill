package com.android.splitthebill.util

import android.app.Activity
import android.content.Context
import android.widget.EditText
import android.widget.Toast

fun Activity.toast(msg: String) {
    return Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun EditText.isValid() : Boolean {
    return this.text.isNullOrEmpty()
}

fun Context.validateInput(username: String, password: String): Boolean {
    return when {
        username.isEmpty() -> {
            Toast.makeText(this, "Username cannot be empty", Toast.LENGTH_SHORT).show()
            false
        }
        username.length < 4 -> {
            Toast.makeText(this, "Username must be at least 4 characters", Toast.LENGTH_SHORT).show()
            false
        }
        password.isEmpty() -> {
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show()
            false
        }
        password.length < 8 -> {
            Toast.makeText(this, "Password must be at least 8 characters", Toast.LENGTH_SHORT).show()
            false
        }
        else -> true
    }
}
