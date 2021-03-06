package com.lakooz.lpctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.lakooz.lpctest.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val TABS= arrayOf("ANNIVERSAIRE", "DEPART", "SOLIDAIRE")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var viewPager=findViewById<ViewPager2>(R.id.viewPager2)
        var tabLayout=findViewById<TabLayout>(R.id.tab_layout)
        var toolbar=findViewById<MaterialToolbar>(R.id.toolbar)
        var swipeRefreshLayout=findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout)
        var fab=findViewById<FloatingActionButton>(R.id.fab)

        var viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = viewPagerAdapter

        setSupportActionBar(toolbar)

        TabLayoutMediator(tabLayout, viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = TABS[position]
            }).attach()


        swipeRefreshLayout.setProgressViewOffset(true, START_SWIPE_REFRESH, resources.getDimension(R.dimen.swipe_refresh_offset).toInt())


        binding = ActivityMainBinding.inflate(layoutInflater)
        val model = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewmodel=model

        model.getPots()

        model.error.observe(this, Observer { isError->
            if(isError)
                Snackbar.make(root,R.string.error,Snackbar.LENGTH_LONG).show()
        })

        model.isRefreshing.observe(this, Observer {it->
            swipeRefreshLayout.isRefreshing=it
        })


        swipeRefreshLayout.setOnRefreshListener {
            model.getPots()
            viewPagerAdapter.updateFragment(viewPager.currentItem)

        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                val viewPagerIdle = state == ViewPager2.SCROLL_STATE_IDLE
                swipeRefreshLayout.isEnabled = viewPagerIdle
            }
        })

        fab.setOnClickListener {
            model.createPot(viewPager.currentItem,viewPagerAdapter)
        }
    }

    companion object {
        private const val START_SWIPE_REFRESH = 50
    }
}