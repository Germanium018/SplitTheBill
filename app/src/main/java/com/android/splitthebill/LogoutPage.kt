package com.android.splitthebill

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogoutPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_logout_page)

        val button_logout = findViewById<Button>(R.id.button_logout)
        button_logout.setOnClickListener {
            Log.e("Exit App", "Exiting App")
            Toast.makeText(this, "Button is clicked!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
    }
}