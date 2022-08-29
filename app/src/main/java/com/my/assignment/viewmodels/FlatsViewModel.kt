package com.my.assignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.my.assignment.models.Cards
import com.my.assignment.models.FlatDetailsModel
import com.my.assignment.repositories.FlatDetailsRepo
import com.my.assignment.utilities.CoroutineHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FlatsViewModel : ViewModel() {


    private val flatDetailsRepo: FlatDetailsRepo by lazy {
        FlatDetailsRepo()
    }

    var flatDetailList = ArrayList<Cards>()

    private val flatMutableLiveData = MutableLiveData<FlatDetailsModel>()


    fun getFlatDetails(): LiveData<FlatDetailsModel?> {
        viewModelScope.launch(Dispatchers.IO.plus(CoroutineHandler.coroutineExceptionHandler)) {
            val response = flatDetailsRepo.getFlatDetails()
            withContext(Dispatchers.Main) {
                response?.let {
                    if (it.isSuccessful) {
                        flatMutableLiveData.value = it.body()
                    } else {
                        flatMutableLiveData.value = null
                    }
                }
            }
        }
        return flatMutableLiveData
    }

}