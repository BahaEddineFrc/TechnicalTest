package com.lakooz.lpctest

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lakooz.lpctest.databinding.PotItemBinding
import com.lakooz.lpctest.model.Pot

class PotAdapter(private val context: Context, private var emptyView: View? = null) : RecyclerView.Adapter<PotAdapter.ViewHolder>() {


    private var pots: List<Pot>? = null
    private var recyclerView: RecyclerView?= null


    fun setPots(pots: List<Pot>?) {
            this.pots = pots
        // TODO : notify data change and handle empty view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       //TODO
    }

    override fun getItemCount(): Int {
        // TODO
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO : bind view holder & format amount properly

    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = null

        super.onDetachedFromRecyclerView(recyclerView)
    }

    inner class ViewHolder(val binding: PotItemBinding) : RecyclerView.ViewHolder(binding.root)
}