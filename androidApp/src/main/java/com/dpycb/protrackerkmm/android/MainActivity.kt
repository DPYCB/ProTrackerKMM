package com.dpycb.protrackerkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.rxjava2.subscribeAsState
import com.badoo.reaktive.rxjavainterop.asRxJava2Observable
import com.dpycb.protrackerkmm.android.presentation.TasksListScreen
import com.dpycb.protrackerkmm.android.presentation.TasksListViewState
import com.dpycb.protrackerkmm.data.Task
import com.dpycb.protrackerkmm.presentation.TasksListSharedViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val viewModel: TasksListSharedViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val viewState = viewModel.getTasksFlow()
                    .asRxJava2Observable()
                    .mapToViewState()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeAsState(initial = TasksListViewState())
                TasksListScreen(viewState)
            }
        }
    }

    private fun Observable<List<Task>>.mapToViewState() = this.map {
        TasksListViewState(
            tasks = it,
            onItemClick = viewModel::removeTask,
            onButtonClick = ::showAddTaskDialog
        )
    }

    private fun showAddTaskDialog() {
        //TODO implement bottom sheet with selection
        viewModel.addTask()
    }
}
