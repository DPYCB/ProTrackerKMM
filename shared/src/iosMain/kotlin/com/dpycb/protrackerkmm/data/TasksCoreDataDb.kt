package com.dpycb.protrackerkmm.data

import platform.CoreData.NSFetchRequest
import platform.CoreData.NSPersistentContainer

class TasksCoreDataDb {
    private val persistentViewContext by lazy {
        NSPersistentContainer("TasksModel")
            .apply { loadPersistentStoresWithCompletionHandler{ _, _ ->  } }
            .viewContext
    }

    fun saveContext() {
        if (!persistentViewContext.hasChanges)
            return
        persistentViewContext.save(null)
    }

    fun addTask() {

    }

    fun getTasks(): List<TaskEntity> {
        return listOf()
    }

    fun removeTask() {

    }
}