package com.dpycb.protrackerkmm.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TasksDao {
    @Query("SELECT * FROM tasks")
    fun getTasks(): List<TaskEntity>

    @Query("DELETE FROM tasks WHERE uid = :arg0")
    fun removeTask(taskId: Long)

    @Insert
    fun addTasks(tasks: List<TaskEntity>)

    @Delete
    fun deleteTask(task: TaskEntity)

    @Update
    fun updateTask(task: TaskEntity)
}