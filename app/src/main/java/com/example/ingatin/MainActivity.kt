package com.example.ingatin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoadapter: todoadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoadapter = todoadapter(mutableListOf())

        rvtodoitems.adapter = todoadapter
        rvtodoitems.layoutManager = LinearLayoutManager(this)

        btnaddtodo.setOnClickListener {
            val todotitle = ettodotitle.text.toString()
            if(todotitle.isNotEmpty()){
                val todo = todo(todotitle)
                todoadapter.addtodo(todo)
            }
        }

        btndelete.setOnClickListener {
            todoadapter.deletetodos()
        }
    }
}