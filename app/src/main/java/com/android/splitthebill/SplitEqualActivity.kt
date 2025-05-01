package com.android.splitthebill

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.android.splitthebill.app.MyApp
import com.android.splitthebill.model.BillingItem

class SplitEqualActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.split_equal)

        val numberOfPeople = intent.getIntExtra("numberOfPeople", 1)
        val expenseAmount = intent.getDoubleExtra("expenseAmount", 0.0)
        val amountPerPerson = if (numberOfPeople > 0) String.format("%.2f", expenseAmount / numberOfPeople) else "0.00"

        val backButton = findViewById<ImageView>(R.id.imageview_backbutton)
        val doneTextView = findViewById<TextView>(R.id.textview_done)
        val summaryListView = findViewById<ListView>(R.id.listview_summary)

        val summaryList = ArrayList<String>()
        for (i in 1..numberOfPeople) {
            val personName = if (i == numberOfPeople) "You" else "Person $i"
            summaryList.add("$personName: Php $amountPerPerson")
        }

        val adapter = ArrayAdapter(this, R.layout.item_summary, R.id.summary_item_text, summaryList)
        summaryListView.adapter = adapter

        backButton.setOnClickListener {
            finish()
        }

        doneTextView.setOnClickListener {
            val latestBillingItem = MyApp.instance.getAllBillings().lastOrNull()
            latestBillingItem?.let {
                val updatedItem = it.copy(amountPerPerson = amountPerPerson)
                MyApp.instance.updateBillingItem(updatedItem)
            }
            startActivity(Intent(this, LandingActivity:: class.java))
            finish()
        }
    }
}
