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

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val etUsername = findViewById<EditText>(R.id.edittext_username)
        val etPassword = findViewById<EditText>(R.id.edittext_password)
        val buttonLogin = findViewById<Button>(R.id.button_login)
        val tvSignup = findViewById<TextView>(R.id.textview_signup)

        buttonLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (etUsername.isValid() || etPassword.isValid()) {
                toast("Fill out the details completely!")
                return@setOnClickListener
            }

            val app = application as MyApp
            if (app.isValidUser(username, password)) {
                toast("Login successfully!")
                startActivity(Intent(this, LandingActivity::class.java))
                finish()
            } else {
                toast("Incorrect username or password!")
            }
        }

        tvSignup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }
}

