package com.example.glliao.catandorid.adapter

import android.support.v4.app.FragmentActivity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.glliao.catandorid.R
import com.example.glliao.catandorid.model.NearbyCatResponse

class NearByListViewAdapter(val activity: FragmentActivity, val catsData: List<NearbyCatResponse.MomentsBean>) : BaseAdapter() {
    private val urlPrefix: String = "http://10.0.2.2:8080/catnip"

    override fun getView(position: Int, convertView: View?, container: ViewGroup?): View {
        val currentCat = catsData[position]
        var view: View
        if (convertView == null) {
            view = activity.layoutInflater.inflate(R.layout.my_cat_list_item, container, false)
        } else {
            view = convertView
        }

        view.findViewById<TextView>(R.id.near_by_cat_name).text = currentCat.id
        view.findViewById<TextView>(R.id.near_by_description).text = currentCat.message
        Glide.with(activity).load(urlPrefix + currentCat.avatar!!.image).into(view.findViewById<ImageView>(R.id.near_by_item_icon))
        for (image in currentCat.thumbs!!) {
            var params = ViewGroup.LayoutParams(276, 263)
            var imageView = ImageView(activity)
            imageView.layoutParams = params
            view.findViewById<LinearLayout>(R.id.near_by_image_container).addView(imageView)

            Glide.with(activity).load(urlPrefix + image.image).into(imageView)
        }

        return view
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
}
