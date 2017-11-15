package com.example.glliao.catandorid.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.glliao.catandorid.R
import com.example.glliao.catandorid.adapter.NearByListViewAdapter
import com.example.glliao.catandorid.domain.CatsNearbyData
import com.example.glliao.catandorid.presenter.CatsNearbyContract
import com.example.glliao.catandorid.presenter.CatsNearbyPresenter

class NearByFragment : Fragment(), CatsNearbyContract.View {
    private val mPresenter = CatsNearbyPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_near_by, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        mPresenter.start()
    }

    override fun showNearbyCats(catsNearbyData: List<CatsNearbyData>?) {
        var listView = view!!.findViewById<ListView>(R.id.near_by_list_view)
        listView.adapter = NearByListViewAdapter(activity, catsNearbyData!!)
    }
}
