package com.my.assignment.utilities

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler


//Coroutine handler to for handing coroutine exceptions
object CoroutineHandler {
    private const val TAG = "CoroutineHandler"
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "coroutineExceptionHandler: ", throwable)
    }
}