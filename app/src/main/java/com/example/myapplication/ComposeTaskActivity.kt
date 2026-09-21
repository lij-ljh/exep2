package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

data class Task(val id: Int, val name: String, var completed: Boolean)

class ComposeTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                TaskListScreen()
            }
        }
    }
}

@Composable
fun TaskListScreen() {
    var tasks by remember {
        mutableStateOf(
            mutableStateListOf(
                Task(1, "Android Basics", true),
                Task(2, "Kotlin 基础", false),
                Task(3, "Jetpack Compose 实战", false)
            )
        )
    }
    var newTaskText by remember { mutableStateOf("") }

    val total = tasks.size
    val done = tasks.count { it.completed }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "课程学习任务",
            fontSize = 22.sp,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Text(
            text = "状态：$total 项任务，完成 $done 项",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        HorizontalDivider(modifier = Modifier.padding(bottom = 8.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(tasks) { task ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = task.completed,
                        onCheckedChange = { checked ->
                            val idx = tasks.indexOf(task)
                            if (idx >= 0) tasks[idx] = task.copy(completed = checked)
                        }
                    )
                    Text(
                        text = task.name,
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f),
                        textDecoration = if (task.completed) TextDecoration.LineThrough else null,
                        color = if (task.completed) MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                                else MaterialTheme.colorScheme.onSurface
                    )
                    IconButton(onClick = { tasks.remove(task) }) {
                        Text(text = "✕", color = MaterialTheme.colorScheme.error)
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = newTaskText,
                onValueChange = { newTaskText = it },
                label = { Text("添加任务") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if (newTaskText.isNotBlank()) {
                        val maxId = tasks.maxOfOrNull { it.id } ?: 0
                        tasks.add(Task(maxId + 1, newTaskText, false))
                        newTaskText = ""
                    }
                }
            ) {
                Text("添加")
            }
        }

        Text(
            text = "完成数：$done / 删除数：",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListPreview() {
    MyApplicationTheme {
        TaskListScreen()
    }
}
