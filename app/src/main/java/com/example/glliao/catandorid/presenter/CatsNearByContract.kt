package com.example.glliao.catandorid.presenter

import com.example.glliao.catandorid.model.NearbyCatResponse

interface CatsNearbyContract {
    interface View {
        fun onGetDataSucceed(data: List<NearbyCatResponse.MomentsBean>?)
        fun onGetDataFail(msg: String)
    }

    interface Presenter {
        fun start()
        fun stop()
    }
}
