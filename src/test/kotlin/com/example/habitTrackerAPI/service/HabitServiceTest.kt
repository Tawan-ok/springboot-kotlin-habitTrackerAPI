package com.example.habittracker.service

import com.example.habitTrackerAPI.model.Habit
import com.example.habitTrackerAPI.model.HabitTracking
import com.example.habitTrackerAPI.repository.HabitRepository
import com.example.habitTrackerAPI.repository.HabitTrackingRepository
import com.example.habitTrackerAPI.service.HabitService
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.*

class HabitServiceTest {

    private lateinit var habitRepository: HabitRepository
    private lateinit var trackingRepository: HabitTrackingRepository
    private lateinit var habitService: HabitService

    @BeforeEach
    fun setUp() {
        habitRepository = mockk()
        trackingRepository = mockk()
        habitService = HabitService(habitRepository, trackingRepository)
    }

    @Test
    fun `createHabit should save and return habit`() {
        val habit = Habit(title = "Test", description = "Testing")
        every { habitRepository.save(any()) } returns habit

        val result = habitService.createHabit(habit)

        assertEquals("Test", result.title)
        verify { habitRepository.save(habit) }
    }

    @Test
    fun `trackHabitToday should save new tracking if not already tracked`() {
        val habitId = UUID.randomUUID()
        val habit = Habit(id = habitId, title = "Drink Water", description = "Test")
        val today = LocalDate.now()
        val savedTracking = HabitTracking(habit = habit, date = today)

        every { habitRepository.findById(habitId) } returns Optional.of(habit)
        every { trackingRepository.findByHabitAndDate(habit, today) } returns null
        every { trackingRepository.save(any()) } returns savedTracking

        val result = habitService.trackHabitToday(habitId)

        assertEquals(habit, result.habit)
        verify { trackingRepository.save(any()) }
    }


    @Test
    fun `trackHabitToday should return existing tracking if already tracked today`() {
        val habitId = UUID.randomUUID()
        val habit = Habit(id = habitId, title = "Test", description = "Track once")
        val today = LocalDate.now()
        val existing = HabitTracking(habit = habit, date = today)

        every { habitRepository.findById(habitId) } returns Optional.of(habit)
        every { trackingRepository.findByHabitAndDate(habit, today) } returns existing

        val result = habitService.trackHabitToday(habitId)

        assertEquals(existing, result)
        verify(exactly = 0) { trackingRepository.save(any()) }
    }



}
