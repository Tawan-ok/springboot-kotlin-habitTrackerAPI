package com.example.habitTrackerAPI.repository

import com.example.habitTrackerAPI.model.Habit
import com.example.habitTrackerAPI.model.HabitTracking
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

interface HabitTrackingRepository : JpaRepository<HabitTracking, UUID> {
    fun findByHabitAndDate(habit: Habit, date : LocalDate) : HabitTracking?
    fun findAllByHabit(habit: Habit) : List<HabitTracking>

}