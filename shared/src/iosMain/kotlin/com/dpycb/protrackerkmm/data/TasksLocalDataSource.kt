package com.dpycb.protrackerkmm.data

actual class TasksLocalDataSource {
    actual fun getTasks(): List<Task> {
        return listOf()
    }
    actual fun addTask(task: Task) {
        //TODO add logic
    }

    actual fun removeTask(taskId: Long) {
        //TODO add logic
    }
}