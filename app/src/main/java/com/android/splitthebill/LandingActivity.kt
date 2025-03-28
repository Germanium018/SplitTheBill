package com.android.splitthebill

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LandingActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing)

        val imgSettings = findViewById<ImageView>(R.id.imageview_settings)
        val imgProfile = findViewById<ImageView>(R.id.imageview_profile)

        imgSettings.setOnClickListener{
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            finish()
        }

        imgProfile.setOnClickListener {
            try {
                val intent = Intent(this, ProfilePage::class.java)
                startActivity(intent)
                finish()
            } catch (e: ClassNotFoundException) {
                Toast.makeText(this, "Profile page is not available.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

    }
}