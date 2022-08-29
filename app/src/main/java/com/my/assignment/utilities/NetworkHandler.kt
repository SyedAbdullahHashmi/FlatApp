package com.my.assignment.utilities

import android.content.Context
import android.net.ConnectivityManager

object NetworkHandler {


    /**
     * Function is to check if the device is connected to network or not
     */
    fun isConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }


}