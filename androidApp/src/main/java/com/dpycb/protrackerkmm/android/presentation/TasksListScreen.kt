package com.dpycb.protrackerkmm.android.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dpycb.protrackerkmm.android.MyApplicationTheme
import com.dpycb.protrackerkmm.data.Task


@Composable
fun TasksListScreen(viewState: State<TasksListViewState>) {
    Box(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.background)) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tasks to do",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            LazyColumn(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)) {
                val itemViewState = viewState.value.tasks.map { it to viewState.value.onItemClick }
                items(itemViewState) {(task, onItemClick) ->
                    TaskListItemView(task, onItemClick)
                }
            }
        }

        FloatingActionButton(
            onClick = viewState.value.onButtonClick,
            modifier = Modifier.align(Alignment.BottomEnd).padding(48.dp)
        ) {
            Icon(Icons.Filled.Add, "")
        }
    }
}

@Composable
fun TaskListItemView(
    task: Task,
    onClick: (Long) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize().clickable { onClick(task.uid) }
    ) {
        Text(
            text = task.name,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface,
        )

        Column {
            Text(
                text = "Start date:",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
            )

            Text(
                text = task.startDate.toString(),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface.copy(alpha = .6f),
            )
        }

        Column {
            Text(
                text = "End date:",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
            )

            Text(
                text = task.endDate.toString(),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface.copy(alpha = .6f),
            )
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        val testTask = Task(name = "TestTask")
        val viewState = remember { mutableStateOf(TasksListViewState(tasks = listOf(testTask))) }
        TasksListScreen(viewState)
    }
}