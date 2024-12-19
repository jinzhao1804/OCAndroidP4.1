package com.openclassrooms.notes.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.data.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for managing and processing notes data.
 * This ViewModel interacts with the NotesRepository to retrieve and manipulate notes.
 */
class NoteViewModel(
    private val notesRepository: NotesRepository // Repository for accessing notes data
) : ViewModel() {

    /**
     * A private mutable StateFlow that holds the list of notes.
     * This is used to update the UI with the latest notes.
     */
    private val _allNotes = MutableStateFlow<List<Note>>(emptyList())

    /**
     * A public StateFlow that emits the current list of notes.
     * The UI can observe this flow to get the latest notes.
     */
    val allNotes: StateFlow<List<Note>> get() = _allNotes

    /**
     * Collects notes from the repository and updates the private mutable state.
     * The UI will observe the public StateFlow to reflect any changes.
     */
    fun collectNotes() {
        viewModelScope.launch {
            // Collect notes from the repository and update the StateFlow
            notesRepository.notes.collect { notes ->
                _allNotes.value = notes // Update the mutable state with new notes
            }
        }
    }
}
