package com.example.ingatin

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class todoadapter(private val todos: MutableList<todo>): RecyclerView.Adapter<todoadapter.todoviewholder>() {
    class todoviewholder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoviewholder {
        return todoviewholder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false))
    }

    fun addtodo(todo: todo){
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deletetodos(){
        todos.removeAll { todo ->
            todo.ischecked
        }
        notifyDataSetChanged()
    }

    private fun togglestrikethrough(tvtodotitle: TextView, isChecked: Boolean){
        if(isChecked){
            tvtodotitle.paintFlags = tvtodotitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvtodotitle.paintFlags = tvtodotitle.paintFlags or STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: todoviewholder, position: Int) {
        val curtodo = todos[position]
        holder.itemView.apply {
            tvtodotitle.text = curtodo.title
            cbdone.isChecked = curtodo.ischecked
            togglestrikethrough(tvtodotitle,curtodo.ischecked)
            cbdone.setOnCheckedChangeListener { _, ischecked ->
                togglestrikethrough(tvtodotitle, ischecked )
                curtodo.ischecked = !curtodo.ischecked
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}