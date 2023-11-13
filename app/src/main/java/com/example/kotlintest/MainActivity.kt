package com.example.kotlintest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlintest.ui.theme.KotlinTestTheme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val taskManager = TaskManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener {
            val description = taskDescriptionEditText.text.toString()
            taskManager.addTask(description)
            updateTaskList()
        }

        completeButton.setOnClickListener {
            val taskId = taskIdEditText.text.toString().toIntOrNull()
            if (taskId != null) {
                taskManager.markTaskAsCompleted(taskId)
                updateTaskList()
            } else {
                // Handle invalid input
            }
        }

        displayButton.setOnClickListener {
            updateTaskList()
        }
    }

    private fun updateTaskList() {
        taskListTextView.text = taskManager.getTaskListAsString()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinTestTheme {
        Greeting("Android")
    }
}