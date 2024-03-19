package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(var tasks:List<Task>,var context: Context):RecyclerView.Adapter<TaskAdapter.Mvh>() {
    class Mvh(view: View):RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.taskimage)
        val owner:TextView=view.findViewById(R.id.owner)
        val dline:TextView=view.findViewById(R.id.deadline)
        val title:TextView=view.findViewById(R.id.title_task)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Mvh {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.task,parent,false)
        return Mvh(view)
    }

    override fun getItemCount(): Int {
        return tasks.count()
    }

    override fun onBindViewHolder(holder: Mvh, position: Int) {
        holder.title.text=tasks[position].title
        holder.owner.text=tasks[position].owner
        holder.dline.text=tasks[position].dl

    }
}