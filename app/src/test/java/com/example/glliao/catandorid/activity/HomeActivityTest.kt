package com.example.glliao.catandorid.activity

import android.widget.TextView
import com.example.glliao.catandorid.R
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HomeActivityTest {
    @Test
    fun testFun() {
        var activity = Robolectric.setupActivity(HomeActivity::class.java)

        var tabNearBy = activity.findViewById<TextView>(R.id.tab_near_by)
        var tabMyCat = activity.findViewById<TextView>(R.id.tab_my_cat)

        tabMyCat.performClick()
        assertTrue(tabMyCat.isEnabled)
        assertFalse(tabNearBy.isEnabled)
    }
}