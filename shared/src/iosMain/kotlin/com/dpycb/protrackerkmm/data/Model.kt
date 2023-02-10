package com.dpycb.protrackerkmm.data

import platform.CoreData.NSManagedObject

data class TaskEntity(
    var uid: Long = 0L,
    var name: String = "",
    var startDate: Long = 0L,
    var endDate: Long = 0L,
    var goals: List<GoalEntity> = listOf()
) : NSManagedObject()

data class GoalEntity(
    var uid: Long = 0L,
    var name: String = "",
    var weight: GoalWeight = GoalWeight.LOW,
    var status: GoalStatus = GoalStatus.NOT_STARTED,
) : NSManagedObject()