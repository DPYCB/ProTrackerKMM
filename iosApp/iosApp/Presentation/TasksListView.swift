import SwiftUI
import shared

struct TasksListView: View {
    private var viewModel = TaskListIosViewModel()
    @State private var tasksViewState: TasksListViewState = TasksListViewState()
    
	var body: some View {
        
        NavigationView {
            
            List(tasksViewState.tasks, id: \.uid) { task in
                HStack {
                    Text(task.name)
                    
                    VStack {
                        Text("Start date:")
                        Text(String(task.startDate))
                    }
                    
                    VStack {
                        Text("End date: ")
                        Text(String(task.endDate))
                    }
                }
                .onTapGesture {
                    tasksViewState.onItemClick(task.uid)
                }
        }
            .navigationTitle("Tasks to do: ")
            .toolbar {
                Button("Add Task") {
                    tasksViewState.onButtonClick()
                }
            }
        }.onAppear {
            viewModel.getTasksFlow().subscribe(isThreadLocal: false) { result in
                if var tasks = result as? [Task] {
                    let viewState = TasksListViewState(
                        tasks: tasks,
                        onItemClick: viewModel.removeTask(taskId:),
                        onButtonClick: viewModel.addTask
                    )
                    self.tasksViewState = viewState
                }
            }
        }
    }
}

struct TasksListView_Previews: PreviewProvider {
	static var previews: some View {
        TasksListView()
	}
}
