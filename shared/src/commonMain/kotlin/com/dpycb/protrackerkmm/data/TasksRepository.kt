package com.dpycb.protrackerkmm.data

import com.badoo.reaktive.subject.behavior.BehaviorSubject
import com.dpycb.protrackerkmm.domain.ITasksRepository
import com.dpycb.protrackerkmm.utils.runOnIo

class TasksRepository(
    private val localDataSource: ITasksLocalDataSource
) : ITasksRepository {
    private val currentTasksSubject = BehaviorSubject<List<Task>>(listOf())

    init {
        runOnIo { localDataSource.getTasks().let(currentTasksSubject::onNext) }
    }

    override fun getTasksObservable() = currentTasksSubject

    override fun addTask(name: String, startDate: Long, endDate: Long) {
        runOnIo {
            val currentTasks = currentTasksSubject.value.toMutableList()
            val newTask = Task(
                name = name,
                startDate = startDate,
                endDate = endDate
            )
            val generatedUid = when (val entityId = localDataSource.addTask(newTask)) {
                0L -> currentTasks.size.toLong()
                else -> entityId
            }
            currentTasks.add(newTask.copy(uid = generatedUid))
            currentTasksSubject.onNext(currentTasks)
        }
    }

    override fun removeTask(taskId: Long) = currentTasksSubject.value.filter { it.uid != taskId }
        .let(currentTasksSubject::onNext)
        .also { runOnIo { localDataSource.removeTask(taskId) } }
}