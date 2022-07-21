package com.example.newtodolist

class Dao {

    fun getTasks(): MutableList<ToDo> {

        var list = mutableListOf<ToDo>()
        list.add(ToDo("Wash my car", "July 5th"))
        list.add(ToDo("Pay my bills", "July 10th"))
        list.add(ToDo("Practice programming", "August 1th"))
        list.add(ToDo("Get a job and become a person", "August 5th"))
        return list
    }
}