package com.android.splitthebill

import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import com.android.splitthebill.app.MyApp
import com.android.splitthebill.model.BillingItem
import java.text.SimpleDateFormat
import java.util.*

class AddExpenseActivity : Activity() {

    private lateinit var backButton: ImageView
    private lateinit var saveText: TextView
    private lateinit var titleInput: EditText
    private lateinit var dateText: TextView
    private lateinit var amountInput: EditText
    private lateinit var numberOfPeopleInput: EditText
    private lateinit var splitButton: Button
    private lateinit var adapter: BillingListAdapter

    private val calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd MMMM, yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_expense)

        // Initialize views
        backButton = findViewById(R.id.imageview_backbutton)
        saveText = findViewById(R.id.textview_save)
        titleInput = findViewById(R.id.edittext_title)
        dateText = findViewById(R.id.textview_date)
        amountInput = findViewById(R.id.edittext_amount)
        numberOfPeopleInput = findViewById(R.id.edittext_numberOfPeople)
        splitButton = findViewById(R.id.button_submit)

        // Back button behavior
        backButton.setOnClickListener {
            finish()
        }

        // Date picker
        dateText.setOnClickListener {
            DatePickerDialog(
                this,
                { _, year, month, day ->
                    calendar.set(year, month, day)
                    dateText.text = dateFormat.format(calendar.time)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        // Save button
        saveText.setOnClickListener {
            handleSubmit()
        }

        // Split button
        splitButton.setOnClickListener {
            handleSubmit()
        }
    }

    private fun handleSubmit() {
        val title = titleInput.text.toString().trim()
        val date = dateText.text.toString().trim()
        val amountStr = amountInput.text.toString().trim()
        val numberStr = numberOfPeopleInput.text.toString().trim()

        if (title.isEmpty() || date.isEmpty() || amountStr.isEmpty() || numberStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val amount = amountStr.toDoubleOrNull()
        val numberOfPeople = numberStr.toIntOrNull()

        if (amount == null || numberOfPeople == null || numberOfPeople <= 0) {
            Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val newExpense = BillingItem(
            title = title,
            date = date,
            amount = amount
        )

        (application as MyApp).addBillingItem(newExpense)
        finish()
    }
}

