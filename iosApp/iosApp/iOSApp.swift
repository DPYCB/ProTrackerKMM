import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        TasksLocalDataSourceSwiftContainer.shared.setInstance(instance: TasksLocalDataSource())
        IosDIKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
            TasksListView()
		}
	}
}
