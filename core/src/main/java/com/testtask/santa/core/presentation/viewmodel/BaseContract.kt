package com.testtask.santa.core.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData


data class Error(
    val type: Int
)

interface BaseContract {

    val error: MutableLiveData<Error>
        get() = MutableLiveData()

}
