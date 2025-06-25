package com.example.habitTrackerAPI

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HabitTrackerApiApplication

fun main(args: Array<String>) {
	runApplication<HabitTrackerApiApplication>(*args)
}
