package com.dpycb.protrackerkmm.data

import com.badoo.reaktive.subject.behavior.BehaviorSubject
import com.dpycb.protrackerkmm.domain.ITasksRepository

class TasksRepository : ITasksRepository {
    private val currentTasksSubject = BehaviorSubject<List<Task>>(listOf())

    override fun getTasksObservable() = currentTasksSubject

    override fun addTask(task: Task) {
        val currentTasks = currentTasksSubject.value.toMutableList()
        currentTasks.add(task.copy(uid = currentTasks.size.toLong()))
        currentTasksSubject.onNext(currentTasks)
    }

    override fun removeTask(taskId: Long) = currentTasksSubject.value.filter { it.uid != taskId }
        .let(currentTasksSubject::onNext)
}