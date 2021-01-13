package com.example.crud_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_data.*

var DB="Data"
var TABLE_NAME="movies"
var COL1="id"
var COL2="movieName"
var COL3="actor"
var COL4="actress"
lateinit var myDB: SQLiteDatabase
lateinit var cv: ContentValues
class addData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

       myDB=openOrCreateDatabase(DB, Context.MODE_PRIVATE,null)

       //var q="create table $TABLE_NAME ($COL1 INTEGER PRIMARY KEY AUTO INCREMENT,$COL2 TEXT, $COL3 TEXT,$COL4 TEXT)"
        myDB.execSQL("create table if not exists movies(movieNAme text,actor text,actress text)")
        btnad.setOnClickListener {
            cv= ContentValues()
            cv.put(COL2,nm.text.toString())
            cv.put(COL3,ac.text.toString())
            cv.put(COL4,act.text.toString())

            var r=myDB.insert(TABLE_NAME,null,cv)
            var t:Long=-1
            if(r==t)
                Toast.makeText(this,"OPPS...!!",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Ok...!!",Toast.LENGTH_SHORT).show()

        }


    }
}
