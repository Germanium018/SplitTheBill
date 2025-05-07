package com.android.splitthebill

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.splitthebill.model.User

class ProfilePage : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSave: Button
    private lateinit var btnHome: Button

    private var currentUser: User = User("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profilepage)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnSave = findViewById(R.id.btnSave)
        btnHome = findViewById(R.id.btnHome)

        etUsername.setText(currentUser.username)
        etPassword.setText(currentUser.password)

        btnSave.setOnClickListener {
            val updatedUsername = etUsername.text.toString()
            val updatedPassword = etPassword.text.toString()
            val confirmedPassword = etConfirmPassword.text.toString()

            if (updatedPassword == confirmedPassword) {
                currentUser = User(username = updatedUsername, password = updatedPassword)
                Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()

                etUsername.isEnabled = false
                etPassword.isEnabled = false
                etConfirmPassword.isEnabled = false
            } else {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
            }
        }

        btnHome.setOnClickListener {
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}