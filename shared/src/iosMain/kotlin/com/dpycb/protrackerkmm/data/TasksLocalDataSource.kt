package com.dpycb.protrackerkmm.data

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual class TasksLocalDataSource : KoinComponent {
    private val coreDataDb: TasksCoreDataDb by inject()
    actual fun getTasks(): List<Task> {
        coreDataDb.getTasks()
        return listOf()
    }
    actual fun addTask(task: Task): Long {
        val taskEntity = task.toEntity()
        coreDataDb.addTask()
        return taskEntity.uid
    }

    actual fun removeTask(taskId: Long) {
        //TODO add logic
        coreDataDb.removeTask()
    }

    private fun Task.toEntity() = TaskEntity(
        name = name,
        startDate = startDate,
        endDate = endDate,
        goals = goals.map { it.toEntity() }
    )

    private fun Goal.toEntity() = GoalEntity(
        name = name,
        weight = weight,
        status = status
    )

    private fun TaskEntity.fromEntity() = Task(
        uid,
        name,
        startDate,
        endDate,
        goals.map { it.fromEntity() }
    )

    private fun GoalEntity.fromEntity() = Goal(
        uid,
        name,
        weight,
        status
    )
}