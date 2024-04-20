package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var taskViewModel : TaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        val newTaskBtnn = findViewById<Button>(R.id.newTaskBtn)
        newTaskBtnn.setOnClickListener {
            NewTaskSheet.show(supportFragmentManager, "newTaskTag")
        }
        taskViewModel.name.observe(this){
            val TaskName = findViewById<TextView>(R.id.taskName)
            TaskName.text = String.format("Task Name : %s" , it)
        }
        taskViewModel.desc.observe(this){
            val desc = findViewById<TextView>(R.id.taskDesc)
            desc.text = String.format("Description Name : %s " , it)
        }
    }
}