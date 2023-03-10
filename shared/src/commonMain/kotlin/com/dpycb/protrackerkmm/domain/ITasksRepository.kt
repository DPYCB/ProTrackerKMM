package com.dpycb.protrackerkmm.domain

import com.badoo.reaktive.observable.Observable
import com.dpycb.protrackerkmm.data.Task

interface ITasksRepository {
    fun getTasksObservable(): Observable<List<Task>>
    fun addTask(name: String, startDate: Long, endDate: Long)
    fun removeTask(taskId: Long)
}