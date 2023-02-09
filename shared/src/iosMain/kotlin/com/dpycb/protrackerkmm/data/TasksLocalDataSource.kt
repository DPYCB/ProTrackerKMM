package com.dpycb.protrackerkmm.data

import org.koin.core.component.KoinComponent

actual class TasksLocalDataSource : KoinComponent {
    private val coreDataDb = TasksCoreDataDb
    actual fun getTasks(): List<Task> {
        //TODO add logic
        coreDataDb.getTasks()
        return listOf()
    }
    actual fun addTask(task: Task) {
        //TODO add logic
        coreDataDb.addTask()
    }

    actual fun removeTask(taskId: Long) {
        //TODO add logic
        coreDataDb.removeTask()
    }
}