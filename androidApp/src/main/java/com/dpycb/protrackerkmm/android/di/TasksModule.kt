package com.dpycb.protrackerkmm.android.di

import android.content.Context
import androidx.room.Room
import com.dpycb.protrackerkmm.android.data.TasksDb
import com.dpycb.protrackerkmm.android.data.TasksLocalDataSource
import com.dpycb.protrackerkmm.data.ITasksLocalDataSource
import org.koin.dsl.module

fun androidTasksModule(context: Context) = module {
    single {
        Room.databaseBuilder(
            context,
            TasksDb::class.java,
            "protracker-kmm-db"
        ).build()
    }
    single { get<TasksDb>().getTasksDao() }
    factory<ITasksLocalDataSource> { TasksLocalDataSource(get()) }
}