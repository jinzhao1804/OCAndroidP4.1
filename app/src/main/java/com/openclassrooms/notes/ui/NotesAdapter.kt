package com.openclassrooms.notes.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.databinding.NoteBinding

/**
 * An adapter for displaying a list of notes in a RecyclerView.
 * @param notes The list of notes to display.
 */
class NotesAdapter(private var notes: List<Note>) : RecyclerView.Adapter<NoteViewHolder>() {

    /**
     * Updates the list of notes displayed by the adapter.
     * @param newNotes The new list of notes to display.
     */
    fun updateNotes(newNotes: List<Note>) {
        notes = newNotes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int =
        notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }
}

/**
 * A view holder for displaying a note in a RecyclerView.
 * @param binding The binding for the note layout.
 */
class NoteViewHolder(private val binding: NoteBinding): RecyclerView.ViewHolder(binding.root) {

    /**
     * Binds the view holder to a note.
     * @param note The note to bind to the view holder.
     */
    fun bind(note: Note) {
        binding.title.text = note.title
        binding.body.text = note.body
    }

}