package com.example.glliao.catandorid.presenter

import com.example.glliao.catandorid.domain.CatsNearby

interface CatsNearbyContract {
    interface View {
        fun showNearbyCats(catsNearby: List<CatsNearby>?)
    }

    interface Presenter {
        fun start()
        fun stop()
    }
}
