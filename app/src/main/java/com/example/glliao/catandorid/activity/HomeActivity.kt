package com.example.glliao.catandorid.activity

import android.annotation.SuppressLint
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

    @BindView(R.id.tab_left)
    lateinit var mLeftTab: TextView

    @BindView(R.id.tab_right)
    lateinit var mRightTab: TextView

    private val mImageResIds = arrayListOf<Int>(R.mipmap.catas, R.mipmap.catgrey, R.mipmap.cats, R.mipmap.catwhite)
    private var mCurrentDotPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
        initBanner()
        initTab()
        setupFragment()
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
    }

    private lateinit var nearbyCatFragment : NearByFragment
    private lateinit var myCatFragment : MyCatFragment

    private fun setupFragment() {
        myCatFragment = MyCatFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, myCatFragment)
        transaction.commit()
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
        mRightTab.setOnClickListener { switchToTabRight() }
        mLeftTab.setOnClickListener { switchToTabLeft() }
    }

    private fun switchToTabRight() {
        mRightTab.isEnabled = false
        mLeftTab.isEnabled = true
    }

    @SuppressLint("ResourceAsColor")
    private fun switchToTabLeft() {
        mRightTab.isEnabled = true
        mLeftTab.isEnabled = false
    }

}
