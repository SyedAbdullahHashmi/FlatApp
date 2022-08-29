package com.my.assignment.ui.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.my.assignment.databinding.MainRowItemBinding
import com.my.assignment.models.Cards
import com.my.assignment.ui.adapters.viewholders.FlatDetailsMainViewHolder

class FlatDetailsMainAdapter : RecyclerView.Adapter<FlatDetailsMainViewHolder>() {

    private var flatDetailList = ArrayList<Cards>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlatDetailsMainViewHolder {
        val mainView =
            MainRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FlatDetailsMainViewHolder(mainView)
    }

    fun passingDataToAdapter(flatDetails: ArrayList<Cards>) {
        this.flatDetailList = flatDetails
        notifyDataSetChanged()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: FlatDetailsMainViewHolder, position: Int) {
        val flatModel = this.flatDetailList[position]
        holder.bindDataView(flatModel)

    }

    override fun getItemCount(): Int {
        return this.flatDetailList.size

    }
}