package com.dpycb.protrackerkmm.android.data

import com.dpycb.protrackerkmm.data.Goal
import com.dpycb.protrackerkmm.data.ITasksLocalDataSource
import com.dpycb.protrackerkmm.data.Task
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.inject

class TasksLocalDataSource(private val tasksDao: TasksDao) : ITasksLocalDataSource {

    override fun getTasks() = tasksDao.getTasks().map { it.fromEntity() }

    override fun addTask(task: Task): Long {
        val taskEntity = task.toEntity()
        tasksDao.addTasks(listOf(task.toEntity()))
        return taskEntity.uid
    }

    override fun removeTask(taskId: Long) = tasksDao.removeTask(taskId)

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