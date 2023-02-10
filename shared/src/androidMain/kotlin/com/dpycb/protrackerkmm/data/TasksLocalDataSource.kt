package com.dpycb.protrackerkmm.data

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual class TasksLocalDataSource : KoinComponent {
    private val tasksDao: TasksDao by inject()

    actual fun getTasks() = tasksDao.getTasks().map { it.fromEntity() }

    actual fun addTask(task: Task): Long {
        val taskEntity = task.toEntity()
        tasksDao.addTasks(listOf(task.toEntity()))
        return taskEntity.uid
    }

    actual fun removeTask(taskId: Long) = tasksDao.removeTask(taskId)

    private fun Task.toEntity() = TaskEntity(
            name = name,
            startDate = startDate,
            endDate = endDate,
            goals = goals.map { it.toEntity() }
        )

    private fun TaskEntity.fromEntity() = Task(
        uid,
        name,
        startDate,
        endDate,
        goals.map { it.fromEntity() }
    )

    private fun Goal.toEntity() = GoalEntity(
        name = name,
        weight = weight,
        status = status
    )

    private fun GoalEntity.fromEntity() = Goal(
        uid,
        name,
        weight,
        status
    )
}