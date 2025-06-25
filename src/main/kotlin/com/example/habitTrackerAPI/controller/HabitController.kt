package com.example.habitTrackerAPI.controller

import com.example.habitTrackerAPI.model.Habit
import com.example.habitTrackerAPI.model.HabitTracking
import com.example.habitTrackerAPI.service.HabitService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/habits")
class HabitController (private val  habitService : HabitService) {

    @PostMapping
    fun createHabit(@RequestBody habit: Habit) : Habit {
        return habitService.createHabit(habit);
    }

    @GetMapping
    fun getAllHabits() : List<Habit> {
        return habitService.getAllHabits()
    }

    @PostMapping("{id}/track")
    fun trackHabitToday(@PathVariable id : UUID) : HabitTracking {
        return habitService.trackHabitToday(id)
    }

    @GetMapping("/{id}/tracking")
    fun getHabitTrackingHistory(@PathVariable id : UUID) : List<HabitTracking> {
        return  habitService.getTrackingHistory(id);
    }

}