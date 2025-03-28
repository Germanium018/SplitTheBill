package com.android.splitthebill

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DeveloperPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_developer_page)

        val btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener {
            Log.e("Exit App", "Exiting App")
            Toast.makeText(this, "Button is clicked!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }
    }
}