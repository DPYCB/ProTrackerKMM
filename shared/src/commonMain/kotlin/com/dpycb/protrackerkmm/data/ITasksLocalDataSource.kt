package com.dpycb.protrackerkmm.data

expect interface ITasksLocalDataSource {
    fun getTasks(): List<Task>
    /**
    Returns generated id by DB framework
     */
    fun addTask(task: Task): Long
    fun removeTask(taskId: Long)
}