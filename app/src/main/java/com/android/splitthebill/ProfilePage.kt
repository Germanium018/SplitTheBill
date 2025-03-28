package com.android.splitthebill

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.graphics.Paint;
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfilePage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.profilepage)

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            Log.e("Exit App", "Exiting App")
            Toast.makeText(this, "Button is clicked!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }

    }
}