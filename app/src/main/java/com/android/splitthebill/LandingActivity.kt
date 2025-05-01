package com.android.splitthebill

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import com.android.splitthebill.app.MyApp
import com.android.splitthebill.util.toast

class LandingActivity : Activity() {

    private lateinit var listView: ListView
    private lateinit var billingAdapter: BillingAdapter

    companion object {
        private const val ADD_EXPENSE_REQUEST_CODE = 123
        private const val SPLIT_EQUAL_REQUEST_CODE = 456
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing)

        listView = findViewById(R.id.listViewBilling)
        billingAdapter = BillingAdapter(this, MyApp.instance.getAllBillings().toMutableList())
        listView.adapter = billingAdapter

        val imgSettings = findViewById<ImageView>(R.id.imageview_settings)
        val imgProfile = findViewById<ImageView>(R.id.imageview_profile)
        val imgAdd = findViewById<ImageView>(R.id.imageview_add)

        imgSettings.setOnClickListener {
            try{
                startActivity(Intent(this, SettingsActivity::class.java))
            } catch (e: Exception) {
                toast("Settings page is not available.")
            }
        }

        imgProfile.setOnClickListener {
            try {
                startActivity(Intent(this, ProfilePage::class.java))
            } catch (e: Exception) {
                toast("Profile page is not available.")
            }
        }

        imgAdd.setOnClickListener {
            try {
                startActivityForResult(Intent(this, AddExpenseActivity::class.java), ADD_EXPENSE_REQUEST_CODE)
            } catch (e: Exception) {
                toast("Add expense page is not available.")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        billingAdapter.updateData(MyApp.instance.getAllBillings())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_EXPENSE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                val intent = Intent(this, SplitEqualActivity::class.java)
                val title = data?.getStringExtra("newTitle") ?: ""
                val date = data?.getStringExtra("newDate") ?: ""
                val amount = data?.getDoubleExtra("newAmount", 0.0) ?: 0.0
                val numberOfPeople = data?.getIntExtra("newNumberOfPeople", 1) ?: 1
                intent.putExtra("expenseTitle", title)
                intent.putExtra("expenseDate", date)
                intent.putExtra("expenseAmount", amount)
                intent.putExtra("numberOfPeople", numberOfPeople)
                startActivityForResult(intent, SPLIT_EQUAL_REQUEST_CODE)
            }
        } else if (requestCode == SPLIT_EQUAL_REQUEST_CODE) {
            onResume()
        }
    }
}

