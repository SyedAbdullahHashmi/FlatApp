package com.my.assignment.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.my.assignment.databinding.ActivityMainBinding
import com.my.assignment.models.FlatDetailsModel
import com.my.assignment.ui.adapters.FlatDetailsMainAdapter
import com.my.assignment.utilities.NetworkHandler
import com.my.assignment.viewmodels.FlatsViewModel

class MainActivity : AppCompatActivity() {

    private val mainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val flatViewModel: FlatsViewModel by lazy {
        ViewModelProvider(this)[FlatsViewModel::class.java]
    }

    private val flatDetailsMainAdapter: FlatDetailsMainAdapter by lazy {
        FlatDetailsMainAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        init()
        configuringRecyclerViewHere()

    }


    private fun init() {
        getFlatDetails()

    }

    private fun configuringRecyclerViewHere() {
        mainBinding.flatMainRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainBinding.flatMainRecyclerView.adapter = flatDetailsMainAdapter
    }

    private fun getFlatDetails() {
        if (NetworkHandler.isConnected(mainBinding.root.context)) {
            mainBinding.progressCircular.visibility = View.VISIBLE
            val flatsObserver = flatViewModel.getFlatDetails()
            if (!flatsObserver.hasActiveObservers()) {
                flatsObserver.observe(this) { flatDetails ->
                    flatDetails?.let {
                        handlingFlatResponse(it)
                    }

                }
            }

        }
    }

    private fun handlingFlatResponse(it: FlatDetailsModel) {
        flatViewModel.flatDetailList = it.cards
        flatDetailsMainAdapter.passingDataToAdapter(flatViewModel.flatDetailList)
        mainBinding.progressCircular.visibility = View.GONE

    }
}