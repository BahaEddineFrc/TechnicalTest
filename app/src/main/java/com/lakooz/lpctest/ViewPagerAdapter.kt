package com.lakooz.lpctest

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.manager.SupportRequestManagerFragment
import java.lang.reflect.Modifier

//Done : Set up the three tabs
class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {

    var fragMan=fm
    var fragIds = listOf<Int>()
    override fun createFragment(position: Int): Fragment {
        var f1=PotsFragment()
        var f2=PotsFragment()
        var f3=PotsFragment()

        fragIds=listOf (f1.id,f2.id,f3.id)

        var bundle = Bundle()
        bundle.putInt("category",position)


        return when (position) {
            0 -> {f1.arguments = bundle; f1 }
            1 -> {f2.arguments = bundle; f2 }
            else -> {f3.arguments = bundle; f3 }
        }
    }

    override fun getItemCount() = 3

    fun updateFragment(position: Int){

        try {
            (fragMan.findFragmentById(fragIds[position] ) as PotsFragment).getUpdatedPotsForCategory()
        }catch (e:Exception){
            e.printStackTrace()
        }

        //var ft : FragmentTransaction = fragMan.beginTransaction()
        //ft.detach(frag); ft.attach(frag); ft.commit()

    }

}