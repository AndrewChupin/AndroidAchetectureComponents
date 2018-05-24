package com.testtask.santa.core.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData


data class Error(
    val type: Int
)


interface BaseContractDelegate {
    fun onReceiveError(error: Throwable) {}
    fun onReceiveLoading(isLoading: Boolean) {}
}


interface BaseContract: ErrorContract, LoadingContract


interface ErrorContract {
    val error: MutableLiveData<Throwable>
        get() = MutableLiveData()
}


interface LoadingContract {
    val isLoading: MutableLiveData<Boolean>
        get() = MutableLiveData()
}

