package com.example.glliao.catandorid.presenter

import android.os.AsyncTask
import com.example.glliao.catandorid.domain.CatsNearbyData
import com.example.glliao.catandorid.domain.HttpUtils
import com.example.glliao.catandorid.model.NearbyCatResponse
import com.example.glliao.catandorid.network.HttpManagerFactory
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import rx.Subscriber
import java.util.*

class CatsNearbyPresenter(private val mCatsNearbyView: CatsNearbyContract.View) : CatsNearbyContract.Presenter {
    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
//    override fun start() {
//        val catsNearbyTask = CatsNearByAsyncTask()
//        catsNearbyTask.execute("http://10.0.2.2:8080/catnip/moment/")
//    }
//
//    override fun stop() {
//    }
//
//    inner class CatsNearByAsyncTask : AsyncTask<String, Unit, List<CatsNearbyData>?>() {
//        private val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
//
//        override fun doInBackground(vararg params: String?): List<CatsNearbyData>? {
//            val response = HttpUtils().doGet(params[0]!!)
//            val gson = GsonBuilder().setDateFormat(DATE_FORMAT).create()
//            return gson.fromJson(JSONObject(response).getString("moments"),
//                    object : TypeToken<List<CatsNearbyData>>() {}.type)
//        }
//
//        override fun onPostExecute(result: List<CatsNearbyData>?) {
//            super.onPostExecute(result)
//            mCatsNearbyView.showNearbyCats(result)
//        }
//    }

    override fun start() {

        HttpManagerFactory.getHttpManager().getCat(object : Subscriber<NearbyCatResponse>() {
            override fun onError(e: Throwable?) {
                mCatsNearbyView.onGetDataFail(e.toString())
            }

            override fun onCompleted() {

            }

            override fun onNext(t: NearbyCatResponse?) {
                mCatsNearbyView.onGetDataSucceed(t!!.moments)
            }

        })

    }
}

