package com.android.splitthebill

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class SettingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        val aboutDevelopers = findViewById<TextView>(R.id.textview_aboutdevs)
        val backToProfile = findViewById<ImageView>(R.id.imageview_backbutton)
        val logout = findViewById<Button>(R.id.button_logout)

        backToProfile.setOnClickListener {
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
            finish()
        }

        aboutDevelopers.setOnClickListener {
            try {
                val intent = Intent(this, Class.forName("com.android.splitthebill.DeveloperPage"))
                startActivity(intent)
                finish()
            } catch (e: ClassNotFoundException) {
                Toast.makeText(this, "Developer page is not available.", Toast.LENGTH_SHORT).show()
            }
        }

        logout.setOnClickListener {
            try {
                val intent = Intent(this, Class.forName("com.android.splitthebill.LogoutPage"))
                startActivity(intent)
                finish()
            } catch (e: ClassNotFoundException) {
                Toast.makeText(this, "Logout page is not available.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}