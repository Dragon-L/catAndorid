package com.example.glliao.catandorid.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.example.glliao.catandorid.R
import com.example.glliao.catandorid.adapter.NearByListViewAdapter
import com.example.glliao.catandorid.model.NearbyCatResponse
import com.example.glliao.catandorid.presenter.CatsNearbyContract
import com.example.glliao.catandorid.presenter.CatsNearbyPresenter

class NearByFragment : Fragment(), CatsNearbyContract.View {
    override fun onGetDataSucceed(data: List<NearbyCatResponse.MomentsBean>?) {
        var listView = view!!.findViewById<ListView>(R.id.near_by_list_view)
        listView.adapter = NearByListViewAdapter(activity, data!!)
    }

    override fun onGetDataFail(msg: String) {
        Toast.makeText(context, "get data failed!!!!!!!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show()
    }

    private val mPresenter = CatsNearbyPresenter(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_near_by, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        mPresenter.start()
    }
}
