package com.dpycb.protrackerkmm.data

expect class TasksLocalDataSource() {
    fun getTasks(): List<Task>
    fun addTask(task: Task)
    fun removeTask(taskId: Long)
}