package com.my.assignment.ui.adapters.viewholders

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.my.assignment.R
import com.my.assignment.databinding.MainRowItemBinding
import com.my.assignment.models.Cards
import com.my.assignment.ui.adapters.HorizontalFlatListAdapter
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import com.zhpan.indicator.utils.IndicatorUtils

class FlatDetailsMainViewHolder(private val rowBinding: MainRowItemBinding) :
    RecyclerView.ViewHolder(rowBinding.root) {

    private val horizontalFlatListAdapter: HorizontalFlatListAdapter by lazy {
        HorizontalFlatListAdapter(rowBinding.horizontalList.context)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun bindDataView(flatModel: Cards) {
        rowBinding.count.text = flatModel.data?.total_matches_count.toString()
        val stringBuilder = StringBuilder()
        flatModel.data?.main_post?.sub_info?.forEach {
            stringBuilder.append(it.text + " \u2022 ")
        }
        rowBinding.description.text = stringBuilder.toString()

        rowBinding.info.text = flatModel.data?.main_post?.info
        rowBinding.title.text = flatModel.data?.main_post?.title

        rowBinding.horizontalList.layoutManager =
            LinearLayoutManager(
                rowBinding.horizontalList.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        rowBinding.horizontalList.adapter = horizontalFlatListAdapter
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rowBinding.horizontalList)

        horizontalFlatListAdapter.passingDataToAdapter(flatModel.data?.horizontal_cards)
        rowBinding.indicatorView.apply {

            setIndicatorStyle(IndicatorStyle.ROUND_RECT)
            setSliderGap(IndicatorUtils.dp2px(4f).toFloat())
            setSlideMode(IndicatorSlideMode.WORM)
            setSliderHeight(6f)
            setSliderColor(rowBinding.indicatorView.context.resources.getColor(R.color.black),
                rowBinding.indicatorView.context.resources.getColor(R.color.black))
            setSliderWidth(20f, 20f)
            setPageSize(flatModel.data?.horizontal_cards?.size!!)
            setCurrentPosition(1)


        }


    }

}