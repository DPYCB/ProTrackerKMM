package com.dpycb.protrackerkmm.presentation

import com.dpycb.protrackerkmm.data.Task
import com.dpycb.protrackerkmm.domain.ITasksRepository

class TasksListSharedViewModel(private val tasksRepository: ITasksRepository) {

    fun getTasksFlow() = tasksRepository.getTasksObservable()

    fun addTask() {
        val randomNames = arrayOf(
            "name1",
            "name2",
            "name3",
            "name4",
            "name5",
        )
        val startDate = 0L
        val endDate = 6000000L
        addTask(randomNames.random(), startDate, endDate)
    }

    fun addTask(name: String, startDate: Long, endDate: Long) = Task(
        name = name,
        startDate = startDate,
        endDate = endDate
    ).let(tasksRepository::addTask)

    fun removeTask(taskId: Long) = tasksRepository.removeTask(taskId)
}