package com.dpycb.protrackerkmm.data

data class Task(
    val uid: Long = 0L,
    val name: String = "",
    val startDate: Long = 0L,
    val endDate: Long = 0L,
    val goals: List<Goal> = listOf()
)

data class Goal(
    val uid: Long = 0L,
    val name: String = "",
    val weight: GoalWeight = GoalWeight.LOW,
    val status: GoalStatus = GoalStatus.NOT_STARTED,
)

enum class GoalWeight {
    HIGH,
    MEDIUM,
    LOW
}

enum class GoalStatus {
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED
}