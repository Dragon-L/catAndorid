package com.example.glliao.catandorid.activity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.glliao.catandorid.R
import com.example.glliao.catandorid.adapter.BannerAdapter
import com.example.glliao.catandorid.fragment.MyCatFragment
import com.example.glliao.catandorid.fragment.NearByFragment

class HomeActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    @BindView(R.id.viewPager)
    lateinit var mViewPager: ViewPager

    @BindView(R.id.indicator)
    lateinit var mIndicator: ViewGroup

    @BindView(R.id.tab_near_by)
    lateinit var mTabNearBy: TextView

    @BindView(R.id.tab_my_cat)
    lateinit var mTabMyCat: TextView

    private val mImageResIds = arrayListOf<Int>(R.mipmap.catas, R.mipmap.catgrey, R.mipmap.cats, R.mipmap.catwhite)
    private var mCurrentDotPosition = 0
    private var mNearbyCatFragment = NearByFragment()
    private var mMyCatFragment = MyCatFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
        initBanner()
        initTab()
        initFragment()
    }

    private fun initBanner() {
        val imageList = ArrayList<ImageView>()

        mImageResIds.forEach {
            val iv = ImageView(this)
            iv.scaleType = ImageView.ScaleType.FIT_XY
            iv.setImageResource(it)
            imageList.add(iv)
        }

        mViewPager.adapter = BannerAdapter(imageList)
        mViewPager.addOnPageChangeListener(this)
        mViewPager.currentItem = 1000
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        (mIndicator.getChildAt(mCurrentDotPosition) as ImageView).setImageResource(R.drawable.dot_bg_white)

        mCurrentDotPosition = position % mImageResIds.size
        (mIndicator.getChildAt(mCurrentDotPosition) as ImageView).setImageResource(R.drawable.dot_bg_green)
    }

    private fun initTab() {
        mTabMyCat.setOnClickListener { switchToTabMyCat() }
        mTabNearBy.setOnClickListener { switchToTabNearBy() }
    }

    private fun switchToTabMyCat() {
        mTabMyCat.isEnabled = false
        mTabNearBy.isEnabled = true
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, mMyCatFragment)
        transaction.commit()
    }

    private fun switchToTabNearBy() {
        mTabMyCat.isEnabled = true
        mTabNearBy.isEnabled = false
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, mNearbyCatFragment)
        transaction.commit()
    }

    private fun initFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, mNearbyCatFragment)
        transaction.commit()
    }

}