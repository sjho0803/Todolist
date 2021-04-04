package com.jhs.miru


import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_itemlist.*
import kotlinx.android.synthetic.main.fragment_todo.*
import kotlinx.android.synthetic.main.fragment_todo.view.*
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list.view.*


class FragmentTodo : Fragment() {

    open var Todolist = arrayListOf(
        "데이터","할일","내일할일","데이터","데이터","데이터","데이터",
        "데이터","데이터","데이터","데이터","데이터","데이터","데이터","데이터",
        "데이터","데이터","데이터","데이터","데이터","데이터","데이터","데이터"
    )





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_todo, container,false)
        view.recyclerview_todo.adapter = TodoFragmentRecyclerViewAdapter()
        view.recyclerview_todo.layoutManager = LinearLayoutManager(activity)
        return view



    }

    inner class TodoFragmentRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val todoText = itemView.todo_text

            init {

                itemView.setOnClickListener {
                    val intent = Intent(context, ItemlistActivity::class.java)
                    intent.putStringArrayListExtra("todolist",Todolist)
                    startActivity(intent)
                }


            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_list, parent, false)

            return CustomViewHolder(view)
        }

        override fun getItemCount(): Int {
            return Todolist.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var view = holder.itemView
            view.todo_text.text = Todolist[position]

        }

    }

}




