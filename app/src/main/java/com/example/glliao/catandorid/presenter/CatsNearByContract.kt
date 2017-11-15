package com.example.glliao.catandorid.presenter

import com.example.glliao.catandorid.domain.CatsNearbyData

interface CatsNearbyContract {
    interface View {
        fun showNearbyCats(catsNearbyData: List<CatsNearbyData>?)
    }

    interface Presenter {
        fun start()
        fun stop()
    }
}
