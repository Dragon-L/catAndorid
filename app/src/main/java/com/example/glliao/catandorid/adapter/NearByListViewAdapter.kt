package com.example.glliao.catandorid.adapter

import android.support.v4.app.FragmentActivity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.glliao.catandorid.R

class NearByListViewAdapter(val activity: FragmentActivity, val textList: List<String>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, container: ViewGroup?): View {
        var view: View
        if (convertView == null) {
            view = activity.layoutInflater.inflate(R.layout.my_cat_list_item, container, false)
        } else {
            view = convertView
        }
        return view
    }

    override fun getItem(position: Int): Any {
        return textList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return textList.size
    }
}
