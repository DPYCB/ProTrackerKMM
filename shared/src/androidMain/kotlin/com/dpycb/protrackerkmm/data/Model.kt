package com.dpycb.protrackerkmm.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0L,
    var name: String = "",
    var startDate: Long = 0L,
    var endDate: Long = 0L,
    var goals: List<GoalEntity> = listOf()
)

data class GoalEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0L,
    var name: String = "",
    var weight: GoalWeight = GoalWeight.LOW,
    var status: GoalStatus = GoalStatus.NOT_STARTED,
)

class EntityConverters {
    @TypeConverter
    fun goalsToGson(goals: List<GoalEntity>) = Gson().toJson(goals)

    @TypeConverter
    fun gsonToGoals(value: String) = Gson().fromJson(value, Array<GoalEntity>::class.java).toList()
}