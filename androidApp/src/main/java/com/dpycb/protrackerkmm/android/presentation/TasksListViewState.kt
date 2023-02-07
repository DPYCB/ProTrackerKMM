package com.dpycb.protrackerkmm.android.presentation

import com.dpycb.protrackerkmm.data.Task

data class TasksListViewState(
    val tasks: List<Task> = listOf(),
    val onItemClick: (Long) -> Unit = {},
    val onButtonClick: () -> Unit = {}
)