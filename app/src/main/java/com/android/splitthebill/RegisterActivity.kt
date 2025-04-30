package com.android.splitthebill

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.splitthebill.app.MyApp
import com.android.splitthebill.util.isValid
import com.android.splitthebill.util.toast
import com.android.splitthebill.util.validateInput

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val etUsername = findViewById<EditText>(R.id.et_username)
        val etPassword = findViewById<EditText>(R.id.et_confirm)
        val btnSignUp = findViewById<Button>(R.id.btn_signup)
        val login = findViewById<TextView>(R.id.tv_login)

        btnSignUp.setOnClickListener {
            if (etUsername.isValid() || etPassword.isValid()) {
                toast("Fill out details completely!")
                return@setOnClickListener
            }

            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (validateInput(username, password)) {
                (application as MyApp).addUser(username, password)
                toast("Created account successfully!")
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
