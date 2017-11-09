package com.example.glliao.catandorid.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.glliao.catandorid.R
import com.example.glliao.catandorid.adapter.NearByListViewAdapter

class NearByFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_near_by, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        var listView = view!!.findViewById<ListView>(R.id.near_by_list_view)
        var textList = listOf<String>("1", "2", "3")

        listView.adapter = NearByListViewAdapter(activity, textList)
    }
}
