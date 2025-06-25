package com.example.habitTrackerAPI.repository

import com.example.habitTrackerAPI.model.Habit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
@Repository
interface HabitRepository : JpaRepository<Habit, UUID>