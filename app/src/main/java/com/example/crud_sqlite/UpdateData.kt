package com.example.crud_sqlite

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.crud_sqlite.ac
import com.example.crud_sqlite.act
import kotlinx.android.synthetic.main.activity_add_data.*
import kotlinx.android.synthetic.main.activity_update_data.*

lateinit var c:ContentValues
class UpdateData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)
        upmn.text=intent.getStringExtra("movie").toString()
        uac.setText(intent.getStringExtra("actor").toString())
        uact.setText(intent.getStringExtra("actress").toString())

        btnup.setOnClickListener {


            myDB = openOrCreateDatabase(DB, Context.MODE_PRIVATE, null)
            c = ContentValues()
            c.put(COL3, uac.text.toString())
            c.put(COL4, uact.text.toString())

            var r = myDB.update("movies", c, "movieName=?", arrayOf(upmn.text.toString()))

            if (r == -1) {
                Toast.makeText(this, "Not Updated...!!", Toast.LENGTH_SHORT).show()
            } else {
                var i = Intent(this, ViewData::class.java)
                startActivity(i)
            }
        }
    }
}
