package com.dpycb.protrackerkmm.di

import com.dpycb.protrackerkmm.data.TasksRepository
import com.dpycb.protrackerkmm.domain.ITasksRepository
import com.dpycb.protrackerkmm.presentation.TasksListSharedViewModel
import org.koin.dsl.module

fun tasksModule() = module {
    single<ITasksRepository> { TasksRepository() }
    factory { TasksListSharedViewModel(get()) }
}