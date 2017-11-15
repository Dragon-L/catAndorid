package com.example.glliao.catandorid.adapter

import android.graphics.Bitmap
import android.os.AsyncTask
import android.support.v4.app.FragmentActivity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.glliao.catandorid.R
import com.example.glliao.catandorid.domain.CatsNearbyData
import com.example.glliao.catandorid.domain.HttpUtils

class NearByListViewAdapter(val activity: FragmentActivity, val catsData: List<CatsNearbyData>) : BaseAdapter() {
    private val urlPrefix: String = "http://10.0.2.2:8080/catnip"

    override fun getView(position: Int, convertView: View?, container: ViewGroup?): View {
        val currentCat = catsData[position]
        var view: View
        if (convertView == null) {
            view = activity.layoutInflater.inflate(R.layout.my_cat_list_item, container, false)

            updateImage(view.findViewById<ImageView>(R.id.near_by_item_icon), currentCat.avatar.imageUrl)
            view.findViewById<TextView>(R.id.near_by_cat_name).text = currentCat.name
            view.findViewById<TextView>(R.id.near_by_description).text = currentCat.description
            //todo  update multiple pictures


        } else {
            view = convertView
        }
        return view
    }

    private fun updateImage(imageView: ImageView?, imageUrl: String) {
        val task = ImageDownloadAsyncTask()
        task.execute(urlPrefix + imageUrl, imageView)
    }

    override fun getItem(position: Int): Any {
        return catsData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return catsData.size
    }

    inner class ImageDownloadAsyncTask : AsyncTask<String, Unit, Bitmap?>() {
        private lateinit var imageView: ImageView
        fun execute(url: String, imageView: ImageView?) {
            this.imageView = imageView!!
            this.execute(url)
        }

        override fun doInBackground(vararg params: String?): Bitmap? {
            return HttpUtils().doDownloadImage(params[0]!!)
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            imageView.setImageBitmap(result)
        }
    }
}
