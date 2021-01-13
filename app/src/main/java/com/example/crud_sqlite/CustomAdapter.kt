package com.example.crud_sqlite

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_data.view.*

lateinit var int:Intent
class CustomAdapter(var con:Context,var mn:ArrayList<String>,var ac:ArrayList<String>,var act:ArrayList<String>): RecyclerView.Adapter<CustomAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v=LayoutInflater.from(con).inflate(R.layout.custom_data,parent,false)
        return MyHolder(v)
    }


    override fun getItemCount(): Int {
      return mn.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.itemView.mnm.text=mn.get(position)
        holder.itemView.acnm.text=ac.get(position)
        holder.itemView.actnm.text=act.get(position)

        holder.itemView.setOnClickListener {
            int= Intent(con,UpdateData::class.java)
            int.putExtra("movie",mn[position])
            int.putExtra("actor",ac[position])
            int.putExtra("actress",act[position])
            con.startActivity(int)
        }
    }

    class MyHolder(iv:View):RecyclerView.ViewHolder(iv)
    {

    }
}