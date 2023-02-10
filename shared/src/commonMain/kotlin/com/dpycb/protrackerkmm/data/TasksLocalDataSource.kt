package com.dpycb.protrackerkmm.data

import org.koin.core.component.KoinComponent

expect class TasksLocalDataSource() : KoinComponent {
    fun getTasks(): List<Task>
    /**
    Returns generated id by DB framework
     */
    fun addTask(task: Task): Long
    fun removeTask(taskId: Long)
}