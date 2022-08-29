package com.my.assignment.ui.adapters

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.my.assignment.databinding.HorizontalItemRowBinding
import com.my.assignment.models.HorizontalCards
import com.my.assignment.ui.activities.MainActivity
import com.my.assignment.ui.adapters.viewholders.HorizontalListViewHolder

class HorizontalFlatListAdapter constructor(val context: Context) :
    RecyclerView.Adapter<HorizontalListViewHolder>() {

    private var horizontalList = ArrayList<HorizontalCards>()
    private var screenWidth = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalListViewHolder {
        val displayMetrics = DisplayMetrics()
        (context as MainActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenWidth = displayMetrics.widthPixels

        val horizontalView =
            HorizontalItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HorizontalListViewHolder(horizontalView)
    }


    fun passingDataToAdapter(horizontalDataList: ArrayList<HorizontalCards>?) {
        this.horizontalList = horizontalDataList!!
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HorizontalListViewHolder, position: Int) {
        val response = this.horizontalList[position]
        holder.bindDataToView(response, screenWidth)

    }

    override fun getItemCount(): Int {
        return this.horizontalList.size
    }
}