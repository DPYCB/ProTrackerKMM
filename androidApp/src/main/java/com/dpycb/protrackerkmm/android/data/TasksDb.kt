package com.dpycb.protrackerkmm.android.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
@TypeConverters(EntityConverters::class)
abstract class TasksDb : RoomDatabase() {
    abstract fun getTasksDao(): TasksDao
}