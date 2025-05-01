package com.android.splitthebill

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.content.Intent
import com.android.splitthebill.model.Note

class AddNotes : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter
    private val notes = mutableListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        recyclerView = findViewById(R.id.notesRecyclerView)
        val fab: FloatingActionButton = findViewById(R.id.addNoteButton)

        adapter = NoteAdapter(
            notes,
            onItemClick = { note ->
                val intent = Intent(this, NoteDetailActivity::class.java)
                intent.putExtra("title", note.title)
                intent.putExtra("content", note.content)
                startActivity(intent)
            },
            onItemLongClick = { position ->
                showDeleteDialog(position)
            }
        )

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            notes.add(Note("Note ${notes.size + 1}", "This is a new note."))
            adapter.notifyItemInserted(notes.size - 1)
        }
    }

    private fun showDeleteDialog(position: Int) {
        AlertDialog.Builder(this)
            .setTitle("Delete Note")
            .setMessage("Are you sure you want to delete this note?")
            .setPositiveButton("Delete") { _: DialogInterface, _: Int ->
                notes.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}

