package com.lakooz.lpctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Done : set content view and declare views

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewPager=findViewById<ViewPager2>(R.id.viewPager2)
        var tabLayout=findViewById<TabLayout>(R.id.tab_layout)
        var toolbar=findViewById<MaterialToolbar>(R.id.toolbar)
        var swipeRefreshLayout=findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout)
        var fab=findViewById<FloatingActionButton>(R.id.fab)

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        setSupportActionBar(toolbar)

        TabLayoutMediator(tabLayout, viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                // TODO : set tabs titles
            }).attach()


       swipeRefreshLayout.setProgressViewOffset(true, START_SWIPE_REFRESH, resources.getDimension(R.dimen.swipe_refresh_offset).toInt())

        // TODO : set up view model



        swipeRefreshLayout.setOnRefreshListener {
            // TODO
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                val viewPagerIdle = state == ViewPager2.SCROLL_STATE_IDLE
                swipeRefreshLayout.isEnabled = viewPagerIdle
            }
        })

        fab.setOnClickListener {
            // TODO
        }
    }

    companion object {
        private const val START_SWIPE_REFRESH = 50
    }
}
