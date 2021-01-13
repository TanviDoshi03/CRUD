package com.example.crud_sqlite

import android.content.Context
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_view_data.*


lateinit var m_name:ArrayList<String>
lateinit var ac:ArrayList<String>
lateinit var act:ArrayList<String>

class ViewData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_data)

        m_name= ArrayList()
        ac= ArrayList()
        act= ArrayList()

        var cv=CustomAdapter(this, m_name,ac,act)
        rv.adapter=cv
        rv.layoutManager=LinearLayoutManager(this)


        myDB=openOrCreateDatabase(DB, Context.MODE_PRIVATE,null)
        var res:Cursor= myDB.rawQuery("select * from movies", null)

        if(res.count==0)
            Toast.makeText(this,"NO Data..",Toast.LENGTH_SHORT).show()

        while(res.moveToNext())
        {
                m_name.add(res.getString(0))
                ac.add(res.getString(1))
                act.add(res.getString(2))
        }


    }
}
