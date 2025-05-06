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
import com.android.splitthebill.util.toast
import kotlin.math.log

class LogoutPage : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout_page)
        val logout = findViewById<Button>(R.id.button_logout)
        val cancel = findViewById<Button>(R.id.button_cancel)

        logout.setOnClickListener {
            Toast.makeText(this, "You have logged out successfully!!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        
        cancel.setOnClickListener{
            startActivity(Intent(this, SettingsActivity::class.java))
            finish()
        }

    }
}
