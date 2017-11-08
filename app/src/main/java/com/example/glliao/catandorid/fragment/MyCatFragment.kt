package com.example.glliao.catandorid.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.glliao.catandorid.R
import com.example.glliao.catandorid.adapter.MyCatListViewAdapter

class MyCatFragment : Fragment() {
    private lateinit var mListView : ListView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_my_cat, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mListView = view!!.findViewById(R.id.myCatListView)

        setupListView()
    }

    private fun setupListView() {
        var data = listOf("cat 1", "cat 2", "cat 3", "cat 4", "cat 5", "cat 6", "cat 7", "cat 7", "cat 7", "cat 7", "cat 7", "cat 7")
        mListView.adapter = MyCatListViewAdapter(activity, data)

    }

}

