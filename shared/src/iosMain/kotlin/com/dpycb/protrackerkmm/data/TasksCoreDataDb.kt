package com.dpycb.protrackerkmm.data

import platform.CoreData.NSPersistentContainer

object TasksCoreDataDb {
    val container by lazy {
        NSPersistentContainer("TasksModel").apply { loadPersistentStoresWithCompletionHandler{ _, _ ->  } }
    }

    fun saveContext() {
        val viewContext = container.viewContext
        if (!viewContext.hasChanges)
            return
        viewContext.save(null)
    }

    fun addTask() {

    }

    fun getTasks() {

    }

    fun removeTask() {

    }
}