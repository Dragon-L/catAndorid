package com.example.glliao.catandorid.presenter

import android.os.AsyncTask
import com.example.glliao.catandorid.domain.CatsNearby
import com.example.glliao.catandorid.domain.HttpUtils
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class CatsNearbyPresenter(private val mCatsNearbyView: CatsNearbyContract.View) : CatsNearbyContract.Presenter {
    override fun start() {
        val catsNearbyTask = CatsNearByAsyncTask()
        catsNearbyTask.execute("http://10.0.2.2:8080/catnip/moment/")
    }

    override fun stop() {
    }

    inner class CatsNearByAsyncTask : AsyncTask<String, Unit, List<CatsNearby>?>() {
        private val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        override fun doInBackground(vararg params: String?): List<CatsNearby>? {
            val response = HttpUtils().doGet(params[0]!!)
            val gson = GsonBuilder().setDateFormat(DATE_FORMAT).create()
            var catsNearByList: List<CatsNearby> = gson.fromJson(JSONObject(response).getString("moments"),
                    object : TypeToken<List<CatsNearby>>() {}.type)
            return catsNearByList
        }

        override fun onPostExecute(result: List<CatsNearby>?) {
            super.onPostExecute(result)
            mCatsNearbyView.showNearbyCats(result)
        }

    }
}

