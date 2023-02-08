package com.dpycb.protrackerkmm.di

import com.dpycb.protrackerkmm.data.TasksLocalDataSource
import com.dpycb.protrackerkmm.data.TasksRepository
import com.dpycb.protrackerkmm.domain.ITasksRepository
import com.dpycb.protrackerkmm.presentation.TasksListSharedViewModel
import org.koin.dsl.module

fun tasksModule() = module {
    single { TasksLocalDataSource() }
    single<ITasksRepository> { TasksRepository(get()) }
    factory { TasksListSharedViewModel(get()) }
}