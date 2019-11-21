package com.lakooz.lpctest

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

//Done : Set up the three tabs
class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {


    override fun createFragment(position: Int): Fragment {
        var fragment = PotsFragment()
        var bundle = Bundle()
        bundle.putInt("category",position)
        fragment.arguments = bundle
        return fragment
    }

    override fun getItemCount() = 3
}