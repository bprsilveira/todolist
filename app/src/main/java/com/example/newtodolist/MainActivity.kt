package com.example.newtodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()

    lateinit var dataSet: MutableList<ToDo>
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataSet = Dao().getTasks()
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        var adapter = ItemAdapter(this, dataSet)
        recyclerView.adapter = adapter

        val layout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = layout

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener { addTask() }

    }

     fun addTask(){

         val editTextTask = findViewById<EditText>(R.id.editTextTask)
         val editTextDeadLine = findViewById<EditText>(R.id.textTaskDeadline)

         val task = editTextTask.text.toString()
         val deadLine = editTextDeadLine.text.toString()

         if(task != ""){

             val newTask = ToDo(task, deadLine)
             dataSet.add(newtask)
             recyclerView.adapter?.notifyDataSetChanged()

             editTextTask.text.clear()
             editTextDeadLine.text.clear()
         }

     }


}