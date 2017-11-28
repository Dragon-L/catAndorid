package com.example.glliao.catandorid.network

import com.example.glliao.catandorid.model.NearbyCatResponse
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Observable

interface CatService {
    @GET("catnip/moment/")
    fun getNearbyCat(): Observable<NearbyCatResponse>

    companion object {
        fun getCatService(): CatService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://10.0.2.2:8080")
                    .build()
            return retrofit.create(CatService::class.java)
        }
    }
}