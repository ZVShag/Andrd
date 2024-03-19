package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val tasklist:RecyclerView=findViewById(R.id.items)
        val tasks= arrayListOf<Task>()

        tasks.add(Task(1,"Vasya","clean table","10.03.2024"))
        tasklist.layoutManager=LinearLayoutManager(this)
        tasklist.adapter=TaskAdapter(tasks,this)
    }
}