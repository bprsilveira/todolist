package com.example.newtodolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val context: Context, private val dataSet: MutableList<ToDo>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    var onItemClick: ((ToDo) -> Unit)? = null

    inner class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        val textTaskName: TextView = view.findViewById(R.id.textTaskName)
        val textTaskDeadLine: TextView = view.findViewById(R.id.textTaskDeadline)

        init {

            itemView.setOnClickListener {

                onItemClick?.invoke(dataSet[adapterPosition])

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return ItemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val todo = dataSet.get(position)
        holder.textTaskName.text = todo.task
        holder.textTaskDeadLine.text = todo.deadLine
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}