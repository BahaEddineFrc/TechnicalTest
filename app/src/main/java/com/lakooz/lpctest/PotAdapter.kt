package com.lakooz.lpctest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lakooz.lpctest.databinding.PotItemBinding
import com.lakooz.lpctest.model.Pot

class PotAdapter(private val context: Context, private var emptyView: View? = null) : RecyclerView.Adapter<PotAdapter.ViewHolder>() {


    private var pots: List<Pot>? = null

    //todo get RV
    private var recyclerView: RecyclerView?= null


    fun setPots(pots: List<Pot>?) {
        //Log.d("hereee","pots at Adapter = ${pots}")
        this.pots = pots
        if (pots == null || pots.isEmpty()) emptyView!!.visibility=View.VISIBLE
        else emptyView!!.visibility=View.GONE

        notifyDataSetChanged()

        // Normally Done : notify data change and handle empty view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Done
        val layoutInflater = LayoutInflater.from(parent.context)
        val potBinding = DataBindingUtil.inflate(layoutInflater, R.layout.pot_item, parent,false) as PotItemBinding
        return ViewHolder(potBinding)
    }

    override fun getItemCount(): Int {
        // Done
        return if (pots==null) 0 else pots!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Done works : bind view holder & "format amount properly" (Done in XML anyway)
        val pot = pots!![position]
        holder.binding.pot=pot
        holder.binding.potAmount.text=pot.amount.toString()
        holder.binding.potCount.text=pot.contributorsCount.toString()

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