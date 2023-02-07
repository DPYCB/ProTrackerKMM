package com.dpycb.protrackerkmm.presentation

import com.badoo.reaktive.observable.observeOn
import com.badoo.reaktive.observable.subscribeOn
import com.badoo.reaktive.observable.wrap
import com.badoo.reaktive.scheduler.ioScheduler
import com.badoo.reaktive.scheduler.mainScheduler
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TaskListIosViewModel : KoinComponent {
    private val viewModel: TasksListSharedViewModel by inject()

    fun getTasksFlow() = viewModel.getTasksFlow()
        .subscribeOn(ioScheduler)
        .observeOn(mainScheduler)
        .wrap()

    fun addTask(name: String, startDate: Long, endDate: Long) = viewModel.addTask(name, startDate, endDate)

    fun addTask() = viewModel.addTask()

    fun removeTask(taskId: Long) = viewModel.removeTask(taskId)

}