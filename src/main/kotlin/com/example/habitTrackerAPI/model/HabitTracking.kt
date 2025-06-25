package com.example.habitTrackerAPI.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class HabitTracking (
    @Id
    @GeneratedValue
    val id : UUID? = null,
    val date : LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "habit_id")
    val habit: Habit = Habit()
)