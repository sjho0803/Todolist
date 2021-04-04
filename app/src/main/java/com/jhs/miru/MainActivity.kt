package com.jhs.miru

import android.app.Activity
import android.app.usage.UsageEvents
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.EventLog
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jhs.miru.R.id
import com.jhs.miru.R.layout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toolbar.*
import kotlinx.android.synthetic.main.fragment_todo.*
import kotlinx.android.synthetic.main.fragment_todo.view.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var fragmentTodo = FragmentTodo()
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_content, fragmentTodo).commit()

        val toolbar = toolbar
        setSupportActionBar(toolbar)



        setContentView(layout.activity_main)

        bottomNavBar.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    id.action_alarm -> {
                        main_toolbar.setBackgroundColor(Color.parseColor("#FF9800"))
                        updateStatusBarColor(this@MainActivity, "#FF9800")
                        toolbar_text.text = "미룬일"
                        var fragmentDelay = FragmentDelay()
                        supportFragmentManager.beginTransaction()
                                .replace(R.id.main_content, fragmentDelay).commit()
                    }
                    id.action_check -> {
                        var fragmentCheck = FragmentCheck()
                        supportFragmentManager.beginTransaction()
                                .replace(R.id.main_content, fragmentCheck).commit()
                        main_toolbar.setBackgroundColor(Color.parseColor("#CD698B"))
                        updateStatusBarColor(this@MainActivity, "#CD698B")
                        toolbar_text.text = "완료"
                    }
                    id.action_todo -> {
                        var fragmentTodo = FragmentTodo()
                        supportFragmentManager.beginTransaction()
                                .replace(R.id.main_content, fragmentTodo).commit()
                        main_toolbar.setBackgroundColor(Color.parseColor("#B1D3E3"))
                        updateStatusBarColor(this@MainActivity, "#B1D3E3")
                        toolbar_text.text = "할일"
                    }
                }
                return true
            }
        })


    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        super.onStart()

//        recyclerview_todo.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                if (!recyclerview_todo.canScrollVertically(-1)) {
//                    Log.d("TAG", "Top of list")
//                    val intent = Intent(this@MainActivity,TodoaddActivity::class.java)
//                    startActivity(intent)
//                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
//
//                } else if (!recyclerview_todo.canScrollVertically(1)) {
//                    Log.d("TAG", "End of list")
//
//                } else {
//                    Log.d("TAG", "idle")
//
//                }
//            }
//        })





//        recyclerview_todo.addOnScrollListener(object : RecyclerView.OnItemTouchListener() {
//            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
//                val curX = e.getX()
//                val cury = e.getY()
//                when (e.action) {
//                    MotionEvent.ACTION_DOWN -> {
//                        // 손가락 눌림
//                        Log.d("TAG", "idle")
//                        val intent = Intent(this@MainActivity,TodoaddActivity::class.java)
//                        startActivity(intent)
//                        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
//                    }
//                    MotionEvent.ACTION_MOVE -> {
//                        // 손가락 누른상태에서 움직임
//                        Log.d("TAG", "idle")
//                        val intent = Intent(this@MainActivity,TodoaddActivity::class.java)
//                        startActivity(intent)
//                        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
//                    }
//                    MotionEvent.ACTION_UP -> {
//
//                        // 손가락 뗌
//                        Log.d("TAG", "idle")
//                        val intent = Intent(this@MainActivity,TodoaddActivity::class.java)
//                        startActivity(intent)
//                        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
//                    }
//
//                }
//            }
//
//            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
//                TODO("Not yet implemented")
//            }
//
//            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
//                TODO("Not yet implemented")
//            }
//
//        })

//        recyclerview_todo.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
//            if (oldScrollY == 0) {
//                Log.d("TAG", "scrollY : 0")
////                            val intent = Intent(this@MainActivity,TodoaddActivity::class.java)
////                            startActivity(intent)
////                            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
////                            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
//            }
//        }




        recyclerview_todo.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (!recyclerview_todo.canScrollVertically(-1)) {
//                    if (recyclerView.scrollState == ie)
////                    Log.d("TAG", "idle")
////                    val intent = Intent(this@MainActivity,TodoaddActivity::class.java)
////                    startActivity(intent)
////                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
////                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)

                } else if (!recyclerview_todo.canScrollVertically(1)) {
                    Log.d("TAG", "idle")
                } else {
//                    Log.d("TAG", "idle")
                }
            }
        })

    }

    fun updateStatusBarColor(context: Activity, color: String?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = context.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(Color.parseColor(color))
        }
    }


}




