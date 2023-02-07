//

import Foundation
import shared

struct TasksListViewState {
    var tasks: [Task] = [Task]()
    var onItemClick: (Int64) -> Void = { (Int64) -> Void in  }
    var onButtonClick: () -> Void = {}
}
