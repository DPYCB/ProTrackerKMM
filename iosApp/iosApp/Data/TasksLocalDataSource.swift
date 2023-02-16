
import Foundation
import shared
import CoreData
import UIKit

class TasksLocalDataSource : ITasksLocalDataSource {
    
    private var lastTaskId: Int64 = -1
    
    lazy var persistentContainer: NSPersistentContainer = {
        let container = NSPersistentContainer(name: "ProTrackerModel")
        container.loadPersistentStores { storeDescription, error in
            if let error = error as NSError? {
                fatalError("Unresolved Error \(error)")
            }
        }
        return container
    }()
    
    func saveContext() {
        let context = persistentContainer.viewContext
        if context.hasChanges {
            do {
                try context.save()
            }
            catch {
                let error = error as NSError
                fatalError("Unresolved Error \(error)")
            }
        }
    }
    
    
    func removeTask(taskId: Int64) {
        let viewContext = persistentContainer.viewContext
        guard let taskToRemove = getTaskEntities().first(where: { entity in
            entity.id == taskId
        }) else { return }
        viewContext.delete(taskToRemove)
        
        do {
            try viewContext.save()
        }
        catch {
            fatalError("Failed to delete task with id \(String(taskId)) \(error)" )
        }
    }
    
    
    func addTask(task: Task) -> Int64 {
        let viewContext = persistentContainer.viewContext
        let entity = getTaskEntityFromTask(task: task)
        
        do {
            try viewContext.save()
            return entity.id
        }
        catch {
            fatalError("Failed to save task \(error)")
        }
    }
    
    func getTasks() -> [Task] {
        return getTaskEntities().map { entity in getTaskFromEntity(entity: entity) }
    }
    
    private func getTaskEntityFromTask(task: Task) -> TaskEntity {
        let entity = TaskEntity(context: persistentContainer.viewContext)
        
        entity.id = task.uid
        entity.name = task.name
        entity.startDate = task.startDate
        entity.endDate = task.endDate
        
        return entity
    }
    
    private func getTaskFromEntity(entity: TaskEntity) -> Task {
        let taskName = entity.name ?? ""
        return Task(uid: entity.id, name: taskName, startDate: entity.startDate, endDate: entity.endDate, goals: [Goal]())
    }
    
    private func getTaskEntities() -> [TaskEntity] {
        let viewContext = persistentContainer.viewContext
        let databaseRequest: NSFetchRequest<TaskEntity> = TaskEntity.fetchRequest()
        do {
            return try viewContext.fetch(databaseRequest)
        }
        catch {
            fatalError("Failed to fetch Tasks \(error)")
        }
    }
    
    private func autoIncrementAndGetId() -> Int64 {
        lastTaskId += 1
        return lastTaskId
    }
}
