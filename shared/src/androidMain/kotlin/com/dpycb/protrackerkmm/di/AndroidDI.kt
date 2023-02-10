package com.dpycb.protrackerkmm.di

import android.content.Context
import androidx.room.Room
import com.dpycb.protrackerkmm.data.TasksDb
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
}