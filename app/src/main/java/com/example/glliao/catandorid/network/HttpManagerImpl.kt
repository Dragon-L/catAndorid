package com.example.glliao.catandorid.network

import com.example.glliao.catandorid.model.NearbyCatResponse
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class HttpManagerImpl : HttpManager {
    override fun getCat(callback: Subscriber<NearbyCatResponse>) {
        CatService.getCatService().getNearbyCat()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback)
    }
}