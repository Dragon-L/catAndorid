package com.example.glliao.catandorid.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.glliao.catandorid.R
import com.example.glliao.catandorid.adapter.BannerAdapter
import com.example.glliao.catandorid.fragment.MyCatFragment
import com.example.glliao.catandorid.fragment.NearByFragment

class HomeActivity : AppCompatActivity() {

    @BindView(R.id.viewPager)
    lateinit var mViewPager: ViewPager

    private val mImageResIds = arrayListOf<Int>(R.mipmap.catas, R.mipmap.catgrey, R.mipmap.cats, R.mipmap.catwhite)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
        initBanner()
        setupFragment()
    }

    private fun initBanner() {
        var imageList = ArrayList<ImageView>()

        mImageResIds.forEach {
            val iv = ImageView(this)
            iv.scaleType = ImageView.ScaleType.FIT_XY
            iv.setImageResource(it)
            imageList.add(iv)
        }

        mViewPager.adapter = BannerAdapter(imageList)
    }

    private lateinit var nearbyCatFragment : NearByFragment
    private lateinit var myCatFragment : MyCatFragment

    private fun setupFragment() {
        myCatFragment = MyCatFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, myCatFragment)
        transaction.commit()
    }

}
