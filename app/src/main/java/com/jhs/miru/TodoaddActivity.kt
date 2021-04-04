package com.jhs.miru

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_todoadd_.*

class TodoaddActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todoadd_)





    }



}