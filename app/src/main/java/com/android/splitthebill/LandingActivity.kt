package com.android.splitthebill

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LandingActivity : Activity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var billingAdapter: BillingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing)

        val imgSettings = findViewById<ImageView>(R.id.imageview_settings)
        val imgProfile = findViewById<ImageView>(R.id.imageview_profile)
        val imgAdd = findViewById<ImageView>(R.id.imageview_add)

        imgSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        imgProfile.setOnClickListener {
            try {
                startActivity(Intent(this, ProfilePage::class.java))
            } catch (e: Exception) {
                Toast.makeText(this, "Profile page is not available.", Toast.LENGTH_SHORT).show()
            }
        }

        imgAdd.setOnClickListener {
            try {
                startActivity(Intent(this, AddExpenseActivity::class.java))
            } catch (e: Exception) {
                Toast.makeText(this, "Add expense page is not available.", Toast.LENGTH_SHORT).show()
            }
        }

        recyclerView = findViewById(R.id.recyclerViewBilling)
        recyclerView.layoutManager = LinearLayoutManager(this)
        billingAdapter = BillingAdapter(MyApp.instance.getAllBillings().toMutableList())
        recyclerView.adapter = billingAdapter
    }

    override fun onResume() {
        super.onResume()
        billingAdapter.updateData(MyApp.instance.getAllBillings())
    }
}

