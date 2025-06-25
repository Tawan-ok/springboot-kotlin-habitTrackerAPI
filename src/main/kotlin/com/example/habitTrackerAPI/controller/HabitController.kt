package com.example.habitTrackerAPI.controller

import com.example.habitTrackerAPI.model.Habit
import com.example.habitTrackerAPI.service.HabitService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

}