package com.example.habitTrackerAPI.service

import com.example.habitTrackerAPI.model.Habit
import com.example.habitTrackerAPI.repository.HabitRepository
import org.springframework.stereotype.Service

@Service
class HabitService (private val habitRepository: HabitRepository) {

    fun createHabit(habit : Habit) : Habit{
        return habitRepository.save(habit)
    }

    fun getAllHabits() : List<Habit> {
        return  habitRepository.findAll();
    }
}