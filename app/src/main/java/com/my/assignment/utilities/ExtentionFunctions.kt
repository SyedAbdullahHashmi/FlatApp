package com.my.assignment.utilities

import android.widget.AbsListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.onScrollDoneGetPosition(onScrollUpdate: (Int) -> Unit) {
    this.addOnScrollListener(object :
        RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            when (newState) {
                AbsListView.OnScrollListener.SCROLL_STATE_FLING -> {
                }
                AbsListView.OnScrollListener.SCROLL_STATE_IDLE -> {
                    print("When User Done it's Scroll")
                    val currentPosition =
                        (this@onScrollDoneGetPosition.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    onScrollUpdate.invoke(currentPosition)
                }
                AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL -> {
                }
            }
        }
    })
}