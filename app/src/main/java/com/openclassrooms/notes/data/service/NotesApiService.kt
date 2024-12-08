package com.openclassrooms.notes.data.service

/**
 * Defines the contract for the API that manages the notes
 */
interface NotesApiService {

    /**
     * Add a note
     * @param note The note to add
     */
    fun addNote(note: Note<String, String>)

    /**
     * Returns all the notes
     * @return the list of notes
     */
    fun getAllNotes(): List<Note<String, String>>

}