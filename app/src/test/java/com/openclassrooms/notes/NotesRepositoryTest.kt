package com.openclassrooms.notes.data.repository

import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.data.service.NotesApiService
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NotesRepositoryTest {

    @Mock
    lateinit var mockNotesApiService: NotesApiService

    private lateinit var notesRepository: NotesRepository

    @Before
    fun setUp() {
        // Initialize Mockito annotations to mock the services
        MockitoAnnotations.openMocks(this)

        // Create the NotesRepository with the mocked NotesApiService
        notesRepository = NotesRepository().apply {
            notesApiService = mockNotesApiService
        }
    }

    @Test
    fun `test notes flow emits correct data`() = runBlocking {
        // Given
        val mockNotes = listOf(
            Note("Title 1", "Body 1"),
            Note("Title 2", "Body 2")
        )

        // Mock the response from the NotesApiService
        Mockito.`when`(mockNotesApiService.getAllNotes()).thenReturn(mockNotes)

        // When
        val notes = notesRepository.notes.first()

        // Then
        assertEquals(mockNotes, notes)
    }
}
