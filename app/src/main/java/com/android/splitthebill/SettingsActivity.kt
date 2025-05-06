package com.android.splitthebill

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.splitthebill.util.toast

class SettingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        val aboutDevelopers = findViewById<ImageView>(R.id.imgAboutDevs)
        val backToProfile = findViewById<ImageView>(R.id.imageview_backbutton)
        //val notes = findViewById<TextView>(R.id.textview_notes)
        val logout = findViewById<Button>(R.id.button_logout)
        val editProfile = findViewById<ImageView>(R.id.imgEditProfile)

        backToProfile.setOnClickListener {
            try{
                startActivity(Intent(this, LandingActivity::class.java))
                finish()
            } catch (e: ClassNotFoundException) {
                toast("Landing page is not available.")
            }
        }

        editProfile.setOnClickListener {
            try{
                startActivity(Intent(this, ProfilePage::class.java))
                finish()
            } catch (e: ClassNotFoundException){
                toast("Profile page is not available.")
            }
        }


        /* notes.setOnClickListener {
            try{
                startActivity(Intent(this, AddNotes::class.java))
                finish()
            } catch (e: ClassNotFoundException){
                toast("Notes page is not available.")
            }
        } */

        aboutDevelopers.setOnClickListener {
            try {
                startActivity(Intent(this, DeveloperPage::class.java))
                finish()
            } catch (e: ClassNotFoundException) {
                toast("Developers page is not available.")
            }
        }

        logout.setOnClickListener {
            try {
                startActivity(Intent(this, LogoutPage::class.java))
                finish()
            } catch (e: ClassNotFoundException) {
                toast("Logout page is not available.")
            }
        }
    }
}
