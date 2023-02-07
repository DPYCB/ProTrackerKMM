package com.dpycb.protrackerkmm.domain

import com.badoo.reaktive.observable.Observable
import com.dpycb.protrackerkmm.data.Task

interface ITasksRepository {
    fun getTasksObservable(): Observable<List<Task>>
    fun addTask(task: Task)
    fun removeTask(taskId: Long)
}