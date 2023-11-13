data class Task(val id: Int, val description: String, var isCompleted: Boolean = false)

class TaskManager {
    private val tasks = mutableListOf<Task>()
    private var taskIDCounter = 1

    fun addTask(description: String) {
        val task = Task(taskIDCounter++, description)
        tasks.add(task)
        println("Task added $task")
    }

    fun markTaskAsCompleted(taskID: Int) {
        val task = tasks.find { it.id == taskID }
        if (task != null) {
            task.isCompleted = true
            println("Task marked as completed $task")
        } else {
            println("Task not found with ID: $taskID")
        }
    }

    fun displayTasks() {
        if (tasks.isEmpty()) {
            println("No tasks available.")
        } else {
            println("Tasks:")
            tasks.forEach { println(it) }
        }
    }
}