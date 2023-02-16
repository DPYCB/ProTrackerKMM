package com.dpycb.protrackerkmm.data

actual interface ITasksLocalDataSource {
    actual fun getTasks(): List<Task>
    actual fun addTask(task: Task): Long
    actual fun removeTask(taskId: Long)
}