package com.example.crud_sqlite

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


   lateinit var i:Intent
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        add.setOnClickListener {

            i = Intent(this, addData::class.java)
            startActivity(i)


        }

        view.setOnClickListener {

            i = Intent(this, ViewData::class.java)
            startActivity(i)

        }
    }
}

