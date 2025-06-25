package com.example.habitTrackerAPI.service

import com.example.habitTrackerAPI.model.Habit
import com.example.habitTrackerAPI.model.HabitTracking
import com.example.habitTrackerAPI.repository.HabitRepository
import com.example.habitTrackerAPI.repository.HabitTrackingRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class HabitService (
    private val habitRepository: HabitRepository,
    private val trackingRepository: HabitTrackingRepository) {

    fun createHabit(habit : Habit) : Habit{
        return habitRepository.save(habit)
    }

    fun getAllHabits() : List<Habit> {
        return  habitRepository.findAll();
    }

    fun trackHabitToday(habitId: UUID) : HabitTracking {
        val habit = habitRepository.findById(habitId).orElseThrow {
            IllegalArgumentException("Habit not found")
        }

        val existing  = trackingRepository.findByHabitAndDate(habit, LocalDateTime.now())
        if(existing != null) {
            return existing
        }

        return  trackingRepository.save(HabitTracking(habit = habit))

    }

    fun getTrackingHistory(habitId: UUID) : List<HabitTracking> {
        val habit = habitRepository.findById(habitId).orElseThrow {
            IllegalArgumentException("Habit not found")
        }
        return  trackingRepository.findAllByHabit(habit)
    }
}