package com.example.glliao.catandorid.network

import com.example.glliao.catandorid.model.NearbyCatResponse
import rx.Subscriber

interface HttpManager {
    fun getCat(callback: Subscriber<NearbyCatResponse>)
}