package com.dpycb.protrackerkmm.di

import com.dpycb.protrackerkmm.data.TasksLocalDataSourceSwiftContainer
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() = startKoin {
    modules(tasksModule() + iosTaskModule())
}

fun iosTaskModule() = module {
    single { TasksLocalDataSourceSwiftContainer.getInstance() }
}