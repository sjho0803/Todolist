package com.jhs.miru

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jhs.miru.Data.Todolist
import kotlinx.android.synthetic.main.activity_itemlist.*
import java.util.*
import kotlin.collections.ArrayList

class ItemlistActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itemlist)

        val intent = intent

        val array : ArrayList<String>? = intent.getStringArrayListExtra("todolist")

        val len = array!!.size

        for (i in 0..len-1) {
            itemlist_title.setText(array.get(i))
        }

    }

}