package com.dpycb.protrackerkmm.data

object TasksLocalDataSourceSwiftContainer {
    private lateinit var tasksLocalDataSourceInstance: ITasksLocalDataSource

    fun setInstance(instance: ITasksLocalDataSource) {
        if (::tasksLocalDataSourceInstance.isInitialized) return
        tasksLocalDataSourceInstance = instance
    }

    fun getInstance(): ITasksLocalDataSource = tasksLocalDataSourceInstance
}