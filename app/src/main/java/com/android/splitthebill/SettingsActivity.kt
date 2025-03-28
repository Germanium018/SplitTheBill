package com.android.splitthebill

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class SettingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        val aboutDevelopers = findViewById<ImageView>(R.id.imgAboutDevs)
        val backToProfile = findViewById<ImageView>(R.id.imageview_backbutton)
        val logout = findViewById<Button>(R.id.button_logout)
        val editProfile = findViewById<ImageView>(R.id.imgEditProfile)

        backToProfile.setOnClickListener {
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
            finish()
        }

        editProfile.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
            finish()
        }

        aboutDevelopers.setOnClickListener {
            try {
                val intent = Intent(this, DeveloperPage::class.java)
                startActivity(intent)
                finish()
            } catch (e: ClassNotFoundException) {
                Toast.makeText(this, "Developer page is not available.", Toast.LENGTH_SHORT).show()
            }
        }

        logout.setOnClickListener {
            try {
                val intent = Intent(this, LogoutPage::class.java)
                startActivity(intent)
                finish()
            } catch (e: ClassNotFoundException) {
                Toast.makeText(this, "Logout page is not available.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}