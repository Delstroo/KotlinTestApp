class Main {
    fun main() {
        val taskManager = TaskManager()

        while (true) {
            println("\nMenu:")
            println("1. Add Task")
            println("2. Mark Task as Completed")
            println("3. Display Tasks")
            println("4. Exit")

            print("Enter your choice: ")
            when (readLine()?.toIntOrNull()) {
                1 -> {
                    print("Enter task description: ")
                    val description = readLine() ?: ""
                    taskManager.addTask(description)
                }
                2 -> {
                    print("Enter task ID to mark as completed: ")
                    val taskId = readLine()?.toIntOrNull() ?: 0
                    taskManager.markTaskAsCompleted(taskId)
                }
                3 -> {
                    taskManager.displayTasks()
                }
                4 -> {
                    println("Exiting program.")
                    return
                }
                else -> {
                    println("Invalid choice. Please enter a number between 1 and 4.")
                }
            }
        }
    }
}