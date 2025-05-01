package com.android.splitthebill

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView


class NoteDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        // Get data from intent
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")

        // Bind to views
        val titleView = findViewById<TextView>(R.id.detailTitle)
        val contentView = findViewById<TextView>(R.id.detailContent)

        titleView.text = title
        contentView.text = content
    }
}
