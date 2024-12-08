package com.openclassrooms.notes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.notes.data.repository.NotesRepository
import com.openclassrooms.notes.ui.NotesAdapter
import kotlinx.coroutines.launch

class NoteViewModel(
    private val notesRepository: NotesRepository, // Assuming this is injected or instantiated somewhere
    private val notesAdapter: NotesAdapter // Assuming this is injected or instantiated somewhere
) : ViewModel() {

    /**
     * Collects notes from the repository and updates the adapter.
     */
    fun collectNotes() {
        viewModelScope.launch {
            // Collect notes from the repository and update the adapter
            notesRepository.notes.collect {
                notesAdapter.updateNotes(it)
            }
        }
    }
}
