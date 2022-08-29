package com.my.assignment.ui.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.with
import com.my.assignment.databinding.HorizontalItemRowBinding
import com.my.assignment.models.HorizontalCards
import com.my.assignment.utilities.GlideApp

class HorizontalListViewHolder(private val horizontalView: HorizontalItemRowBinding) :
    RecyclerView.ViewHolder(horizontalView.root) {
    fun bindDataToView(response: HorizontalCards, screenWidth: Int) {
        val itemWidth = screenWidth / 1.1
        val layoutParams = horizontalView.horizontalCard.layoutParams
        layoutParams.height = layoutParams.height
        layoutParams.width = itemWidth.toInt()
        horizontalView.title.text = response.title
        val stringBuilder = StringBuilder()
        response.sub_info.forEach {
            stringBuilder.append(it.text + " \u2022 ")
        }
        horizontalView.subInfo.text = stringBuilder.toString()
        horizontalView.info.text = response.info
        GlideApp.with(horizontalView.profilePicUrl.context)
            .load(response.assigned_to?.profile_pic_url)
            .into(horizontalView.profilePicUrl)

        horizontalView.orgName.text = response.assigned_to?.org_name

    }


}