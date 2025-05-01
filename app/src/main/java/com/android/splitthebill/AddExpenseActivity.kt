package com.android.splitthebill

import com.android.splitthebill.SplitEqualActivity
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.splitthebill.app.MyApp
import com.android.splitthebill.model.BillingItem
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddExpenseActivity : Activity() {

    private lateinit var backButton: ImageView
    private lateinit var saveTextView: TextView
    private lateinit var titleEditText: EditText
    private lateinit var dateText: TextView
    private lateinit var amountEditText: EditText
    private lateinit var numberOfPeopleEditText: EditText
    private lateinit var splitOptionsButton: Button

    private val calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd MMMM, yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_expense)

        backButton = findViewById(R.id.imageview_backbutton)
        saveTextView = findViewById(R.id.textview_save)
        titleEditText = findViewById(R.id.edittext_title)
        dateText = findViewById(R.id.textview_date)
        amountEditText = findViewById(R.id.edittext_amount)
        numberOfPeopleEditText = findViewById(R.id.edittext_numberOfPeople)
        splitOptionsButton = findViewById(R.id.button_submit)

        backButton.setOnClickListener {
            finish()
        }

        saveTextView.setOnClickListener {
            finish()
        }

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

        splitOptionsButton.setOnClickListener {
            val title = titleEditText.text.toString().trim()
            val date = dateText.text.toString().trim()
            val amountStr = amountEditText.text.toString().trim()
            val numberStr = numberOfPeopleEditText.text.toString().trim()

            if (title.isEmpty() || date.isEmpty() || amountStr.isEmpty() || numberStr.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = amountStr.toDoubleOrNull()
            val numberOfPeople = numberStr.toIntOrNull()

            if (amount == null || numberOfPeople == null || numberOfPeople <= 0) {
                Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newExpense = BillingItem(
                title = title,
                date = date,
                amount = amount
            )

            (application as MyApp).addBillingItem(newExpense)

            val intent = Intent(this, SplitEqualActivity::class.java)
            intent.putExtra("expenseTitle", title)
            intent.putExtra("expenseDate", date)
            intent.putExtra("expenseAmount", amount)
            intent.putExtra("numberOfPeople", numberOfPeople)
            startActivityForResult(intent, 456)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 456 && resultCode == RESULT_OK) {
            finish()
        }
    }
}

