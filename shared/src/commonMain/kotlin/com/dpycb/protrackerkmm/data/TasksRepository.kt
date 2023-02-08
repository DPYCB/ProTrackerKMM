package com.dpycb.protrackerkmm.data

import com.badoo.reaktive.subject.behavior.BehaviorSubject
import com.dpycb.protrackerkmm.domain.ITasksRepository

class TasksRepository(
    private val localDataSource: TasksLocalDataSource
) : ITasksRepository {
    private val currentTasksSubject = BehaviorSubject<List<Task>>(listOf())

    init {
        localDataSource.getTasks().let(currentTasksSubject::onNext)
    }

    override fun getTasksObservable() = currentTasksSubject

    override fun addTask(name: String, startDate: Long, endDate: Long) {
        val currentTasks = currentTasksSubject.value.toMutableList()
        val newTask = Task(
            uid = currentTasks.size.toLong(),
            name = name,
            startDate = startDate,
            endDate = endDate
        )
        currentTasks.add(newTask)
        localDataSource.addTask(newTask)
        currentTasksSubject.onNext(currentTasks)
    }

    override fun removeTask(taskId: Long) = currentTasksSubject.value.filter { it.uid != taskId }
        .let(currentTasksSubject::onNext)
        .also { localDataSource.removeTask(taskId) }
}