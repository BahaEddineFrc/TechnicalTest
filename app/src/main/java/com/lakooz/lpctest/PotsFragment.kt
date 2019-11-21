package com.lakooz.lpctest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lakooz.lpctest.databinding.PotsFragmentBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.pots_fragment.*

class PotsFragment : Fragment() {

    lateinit var model: PotsViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var emptyPlaceholder: LinearLayout
    var fragmentCreated=false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = PotsFragmentBinding.inflate(inflater, container, false)

        // set up recycler view
        recyclerView = binding.root.findViewById(R.id.recycler_view)
        emptyPlaceholder = binding.root.findViewById(R.id.empty_placeholder)


        // Done : set up view model
        model = ViewModelProviders.of(this).get(PotsViewModel::class.java)
        binding.viewmodel = model

        setUpRecyclerView()

        fragmentCreated=true
        return binding.root
    }

    private fun setUpRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        var adapter = PotAdapter(context!!, emptyPlaceholder)
        recyclerView.adapter = adapter

        getUpdatedPotsForCategory()

        model.pots.observe(this, Observer { pots ->
            adapter.setPots(pots)
        })
    }

    fun getUpdatedPotsForCategory() {
        arguments?.getInt("category")?.let {category->
            model.getPots(category)
        }
    }


}