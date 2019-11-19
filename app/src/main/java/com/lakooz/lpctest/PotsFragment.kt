package com.lakooz.lpctest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakooz.lpctest.databinding.PotsFragmentBinding
import kotlinx.android.synthetic.main.pots_fragment.*

class PotsFragment : Fragment() {

    lateinit var model :PotsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = PotsFragmentBinding.inflate(inflater, container, false)

        // set up recycler view
        setUpRecyclerView()

        // Done : set up view model
        //todo: get category number
        var category = 1
        model = ViewModelProviders.of(this).get(PotsViewModel::class.java)
        binding.viewmodel=model

        return binding.root
    }

    private fun setUpRecyclerView() {
        var adapter = PotAdapter(context!!,empty_placeholder)
        recycler_view.adapter=adapter
        recycler_view.layoutManager= LinearLayoutManager(context)

        var category = 1
        model.getPots(category)
        model.pots.observe(this, Observer { pots->
            adapter.setPots(pots)
        })
    }
}