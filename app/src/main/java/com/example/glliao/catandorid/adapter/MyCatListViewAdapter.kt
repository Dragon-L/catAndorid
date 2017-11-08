package com.example.glliao.catandorid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.glliao.catandorid.R

class MyCatListViewAdapter(val context: Context, val data: List<String>): BaseAdapter() {
    val infalter: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        if (convertView == null) {
            view = infalter!!.inflate(R.layout.my_cat_list_item, null, false)
        } else {
            view = convertView
        }
        view.findViewById<TextView>(R.id.content).text = data[position]
        return view
    }

    override fun getItem(position: Int): Any {
        return  data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }
}