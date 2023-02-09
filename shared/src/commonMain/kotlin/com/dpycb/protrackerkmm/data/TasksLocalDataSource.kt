package com.dpycb.protrackerkmm.data

import org.koin.core.component.KoinComponent

expect class TasksLocalDataSource() : KoinComponent {
    fun getTasks(): List<Task>
    fun addTask(task: Task)
    fun removeTask(taskId: Long)
}